package ua.dp.wheaten.site.root.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by kkm on 03.07.2016.
 */
@Entity
@Table(name = "PURCHASE_DETAIL")
public class PurchaseDetail extends PersistableObjectAudit {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "SUMM")
    private BigDecimal sum;

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID")
    private PurchaseDocument document;

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

    public PurchaseDocument getDocument() {
        return document;
    }

    public void setDocument(PurchaseDocument document) {
        this.document = document;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

}
