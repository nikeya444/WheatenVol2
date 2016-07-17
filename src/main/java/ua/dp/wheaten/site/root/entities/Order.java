package ua.dp.wheaten.site.root.entities;

import ua.dp.wheaten.site.root.validation.Date;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kkm on 03.07.2016.
 */
@Entity
@Table(name = "ORDERS")
public class Order extends PersistableObjectAudit {

    @Column(name = "TYPE")
    private DocumentType type;

    @ManyToOne
    @JoinColumn(name = "PARTNER_ID")
    private Partner partner;

    @Column(name = "STATUS")
    private boolean status;

    @Column(name = "DATE_OF_DOCUMENT")
    private LocalDate dateOfDocument;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<OrderDetail> details = new ArrayList<>();

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
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

    public LocalDate getDateOfDocument() {
        return dateOfDocument;
    }

    public void setDateOfDocument(LocalDate dateOfDocument) {
        this.dateOfDocument = dateOfDocument;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    public void add(OrderDetail detail) {
        detail.setOrder(this);
        this.details.add(detail);
    }

    public void addAll(Collection<OrderDetail> details) {
        this.details.addAll(
                details.stream()
                    .peek(d -> d.setOrder(this))
                    .collect(Collectors.toList())
        );
    }
}
