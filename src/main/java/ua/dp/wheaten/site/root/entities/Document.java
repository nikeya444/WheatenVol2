package ua.dp.wheaten.site.root.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ua.dp.wheaten.site.root.validation.Date;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
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
        SALE, PURCHASE, MOVEMENT
    }

    public Document() {
    }

    public Document(Type type, Partner partner, boolean status, LocalDate dateOfDocument) {
        this.type = type;
        this.partner = partner;
        this.status = status;
        this.dateOfDocument = dateOfDocument;
    }

    public Document(Type type, Partner partner, boolean status, LocalDate dateOfDocument, List<DocumentDetail> details) {
        this.type = type;
        this.partner = partner;
        this.status = status;
        this.dateOfDocument = dateOfDocument;
        this.details = details;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "DOCUMENT_TYPE")
    @JsonProperty(value = "documentType")
    @NotNull(message = "Type is incorrect")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "PARTNER_ID")
    @NotNull(message = "Partner must be selected")
  //  @JsonProperty(value = "partnerId")
    private Partner partner;

    @Column(name = "STATUS")
    private boolean status;

    @Date
    @Column(name = "DATE_OF_DOCUMENT")
    private LocalDate dateOfDocument;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    //@ElementCollection(fetch = FetchType.EAGER)
   // @CollectionTable(name = "DETAILS", joinColumns = @JoinColumn(name = "DOCUMENT_ID"))
    @Size(min = 1, message = "Wrong details")
    @Valid
    private List<DocumentDetail> details = new ArrayList<>();

    public Type getType() {
        return type;
    }

    public void setType(Type documentType) {
        this.type = documentType;
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

    public void addAllDetails(Collection<DocumentDetail> details) {
        for (DocumentDetail detail: details) {
            detail.setDocument(this);
        }
        this.getDetails().addAll(details);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Document)) return false;
        Document obj = (Document) o;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Document{" +
                "type=" + type +
                ", partner=" + partner +
                ", status=" + status +
                ", dateOfDocument=" + dateOfDocument +
                ", details=" + details +
                '}';
    }
}
