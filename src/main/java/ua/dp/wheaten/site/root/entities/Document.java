package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 27.03.15
 * Time: 22:28
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class Document extends PersistableObjectAudit {

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

    @Override
    public String toString() {
        return "Document{" +
                "documentType=" + documentType +
                ", partner=" + partner +
                '}';
    }
}
