package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kkm on 03.07.2016.
 */
@Entity
@Table(name = "PURCHASE_DOCUMENTS")
public class PurchaseDocument extends PersistableObjectAudit {

    public static final DocumentType TYPE = DocumentType.PURCHASE;

    @Column(name = "DATE_OF_DOCUMENT")
    private LocalDate dateOfDocument;

    @ManyToOne
    @JoinColumn(name = "PARTNER_ID")
    private Partner partner;

    @Column(name = "STATUS")
    private boolean status;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<PurchaseDetail> details = new LinkedList<>();

    public LocalDate getDateOfDocument() {
        return dateOfDocument;
    }

    public void setDateOfDocument(LocalDate dateOfDocument) {
        this.dateOfDocument = dateOfDocument;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<PurchaseDetail> getDetails() {
        return details;
    }

    public void setDetails(List<PurchaseDetail> details) {
        this.details = details;
    }

    public void addDetail(PurchaseDetail detail) {
        detail.setDocument(this);
        this.details.add(detail);
    }

    public void addAll(Collection<PurchaseDetail> details) {
        this.details.addAll(
                details.stream()
                        .peek(d -> d.setDocument(this))
                        .collect(Collectors.toList())
        );
    }

    public DocumentType getType() {
        return TYPE;
    }
}
