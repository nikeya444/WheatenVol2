package ua.dp.wheaten.site.root.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 27.03.15
 * Time: 22:28
 * To change this template use File | Settings | File Templates.
 */
@Entity
@NamedEntityGraph(name = "graph.document.details",
        attributeNodes = @NamedAttributeNode("details")
)
@Table(name = "DOCUMENTS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Document extends PersistableObjectAudit {

    public enum Type {
        SALE, PURCHASE, MOVEMENT, REFUND, WRITEOFF
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "DOCUMENT_TYPE")
    @JsonProperty(value = "documentType")
    private Type documentType;

    @ManyToOne
    @JoinColumn(name = "PARTNER_ID")
    @JsonProperty(value = "partnerId")
    private Partner partner;

    @Column(name = "STATUS")
    private boolean status;

    @Column(name = "DATE_OF_DOCUMENT")
    private LocalDate dateOfDocument;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DocumentDetail> details = new ArrayList<>();

    void correctInOutDetail(DocumentDetail detail) {
        switch (this.documentType) {
            case REFUND:
            case PURCHASE: detail.negateSum();
                break;
            case WRITEOFF:
            case SALE:     detail.negateQuantity();
        }
    }

    @PrePersist
    @PreUpdate
    private void correctDetails() {
        for (DocumentDetail detail: this.details) {
            detail.setDocument(this);
        }
        this.correctMovementDetails();
    }

    private void correctMovementDetails() {
        if (this.documentType != Type.MOVEMENT) return;

        if ( (details.size() % 2) != 0 )
            throw new IllegalArgumentException("details size must be an even number");

         this.doCorrectMovementDetails(details);
    }

    private void doCorrectMovementDetails(List<DocumentDetail> details) {
        for (int i = 0; i < details.size(); i += 2) {
            DocumentDetail out = details.get(i);
            DocumentDetail in = details.get(i+1);

            out.negateQuantity();
            in.negateSum();
        }
    }

    public Type getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Type documentType) {
        this.documentType = documentType;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner company) {
        this.partner = company;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getDateOfDocument() {
        return dateOfDocument;
    }

    public void setDateOfDocument(LocalDate dateOfDocument) {
        this.dateOfDocument = dateOfDocument;
    }

    public List<DocumentDetail> getDetails() {
        return details;
    }

    public void setDetails(List<DocumentDetail> details) {
        this.details = details;
    }

    public void addDetail(DocumentDetail detail) {
        this.details.add(detail);
        detail.setDocument(this);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id " + getId() +
                ", dateOfDocument=" + dateOfDocument +
                ", documentType=" + documentType +
                ", partner=" + partner +
                '}';
    }
}
