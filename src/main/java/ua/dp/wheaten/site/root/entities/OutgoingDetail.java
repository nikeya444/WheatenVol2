package ua.dp.wheaten.site.root.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 31.08.15
 * Time: 0:44
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "OUTGOING_DETAILS")
public class OutgoingDetail extends DocumentDetail {

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID")
    private OutgoingDocument document;

    @ManyToOne
    @JoinColumn(name = "STORAGE_FROM")
    private Storage storageFrom;

    public OutgoingDocument getDocument() {
        return document;
    }

    public void setDocument(OutgoingDocument document) {
        this.document = document;
    }

    public Storage getStorageFrom() {
        return storageFrom;
    }

    public void setStorageFrom(Storage storageFrom) {
        this.storageFrom = storageFrom;
    }
}
