package ua.dp.wheaten.site.root.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 31.08.15
 * Time: 0:37
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "MOVEMENT_DETAILS")
public class MovementDetail extends DocumentDetail {

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID")
    private MovementDocument document;

    @ManyToOne
    @JoinColumn(name = "STORAGE_FROM")
    private Storage storageFrom;

    @ManyToOne
    @JoinColumn(name = "STORAGE_TO")
    private Storage storageTo;

    public MovementDocument getDocument() {
        return document;
    }

    public void setDocument(MovementDocument document) {
        this.document = document;
    }

    public Storage getStorageFrom() {
        return storageFrom;
    }

    public void setStorageFrom(Storage storageFrom) {
        this.storageFrom = storageFrom;
    }

    public Storage getStorageTo() {
        return storageTo;
    }

    public void setStorageTo(Storage storageTo) {
        this.storageTo = storageTo;
    }
}
