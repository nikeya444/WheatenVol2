package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by kkm on 03.07.2016.
 */
@Entity
@Table(name = "OPERATIONS")
public class Operation extends PersistableObjectAudit {

    public Operation() {
    }

    public Operation(Integer idDoc, DocumentType type, Product product, Integer quantity, Storage storage, BigDecimal sum) {
        this.idDoc = idDoc;
        this.type = type;
        this.product = product;
        this.quantity = quantity;
        this.storage = storage;
        this.sum = sum;
    }

    @Column(name = "ID_DOC")
    private Integer idDoc;

    @Column(name = "TYPE")
    private DocumentType type;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "STORAGE_ID")
    private Storage storage;

    @Column(name = "SUMM")
    private BigDecimal sum;

    public Integer getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
