package ua.dp.wheaten.site.root.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 31.08.15
 * Time: 0:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "INCOMING_DETAILS")
public class IncomingDetail extends DocumentDetail {

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID")
    private IncomingDocument document;

    @ManyToOne
    @JoinColumn(name = "STORAGE_TO")
    private Storage storageTo;

    public IncomingDocument getDocument() {
        return document;
    }

    public void setDocument(IncomingDocument document) {
        this.document = document;
    }

    public Storage getStorageTo() {
        return storageTo;
    }

    public void setStorageTo(Storage storageTo) {
        this.storageTo = storageTo;
    }
}
