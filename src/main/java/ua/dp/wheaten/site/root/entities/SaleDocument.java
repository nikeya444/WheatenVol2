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
@Table(name = "SALE_DOCUMENTS")
public class SaleDocument extends PersistableObjectAudit {

    public static final DocumentType TYPE = DocumentType.SALE;

    @Column(name = "DATE_OF_DOCUMENT")
    private LocalDate dateOfDocument;

    @ManyToOne
    @JoinColumn(name = "PARTNER_ID")
    private Partner partner;

    @Column(name = "STATUS")
    private boolean status;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<SaleDetail> details = new LinkedList<>();

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

    public List<SaleDetail> getDetails() {
        return details;
    }

    public void setDetails(List<SaleDetail> details) {
        this.details = details;
    }

    public void addDetail(SaleDetail detail) {
        detail.setDocument(this);
        this.details.add(detail);
    }

    public void addAll(Collection<SaleDetail> details) {
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
