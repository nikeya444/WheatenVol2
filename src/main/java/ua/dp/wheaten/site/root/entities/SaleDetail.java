package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kkm on 03.07.2016.
 */
@Entity
@Table(name = "SALE_DETAILS")
public class SaleDetail extends PersistableObjectAudit {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "SUMM")
    private BigDecimal sum;

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID")
    private SaleDocument document;

    @ManyToOne
    @JoinColumn(name = "STORAGE_ID")
    private Storage storage;

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

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public SaleDocument getDocument() {
        return document;
    }

    public void setDocument(SaleDocument document) {
        this.document = document;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
