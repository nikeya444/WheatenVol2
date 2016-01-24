package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import javax.xml.soap.Detail;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 27.03.15
 * Time: 22:28
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "DOCUMENTS")
public class Document extends PersistableObjectAudit {

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_TYPE_ID")
    private DocumentType documentType;

    @ManyToOne
    @JoinColumn(name = "PARTNER_ID")
    private Partner partner;

    @Column(name = "STATUS")
    private byte status;

    @Column(name = "DATE_OF_DOCUMENT")
    @Temporal(TemporalType.DATE)
    private Date dateOfDocument;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DocumentDetail> details = new ArrayList<>();

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner company) {
        this.partner = company;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Date getDateOfDocument() {
        return dateOfDocument;
    }

    public void setDateOfDocument(Date dateOfDocument) {
        this.dateOfDocument = dateOfDocument;
    }

    public List<DocumentDetail> getDetails() {
        return details;
    }

    public void setDetails(List<DocumentDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentType=" + documentType +
                ", partner=" + partner +
                '}';
    }
}
