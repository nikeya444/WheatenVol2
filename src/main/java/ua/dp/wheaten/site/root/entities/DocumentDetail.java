package ua.dp.wheaten.site.root.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 12.05.15
 * Time: 22:39
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "DETAILS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentDetail extends PersistableObjectAudit {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    @JsonProperty(value = "productId")
    private Product product;

    @Column(name = "QUANTITY")
    @JsonProperty(value = "quantity")
    private Integer quantity;

    @Transient
    @JsonProperty(value = "price")
    private BigDecimal price;

    @Column(name = "SUMM")
    private BigDecimal sum;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID")
    private Document document;

    @ManyToOne
    @JoinColumn(name = "STORAGE_ID")
    private Storage storage;

    @PrePersist
    @PreUpdate
    private void correctDetailDueToDocumentType() {
        System.err.println(price);
        sum = price.multiply(new BigDecimal(quantity));
        this.document.correctInOutDetail(this);
    }

    @PostLoad
    private void abs() {
        if (this.document.getDocumentType() == Document.Type.MOVEMENT) return;
        this.sum = this.sum.abs();
        this.quantity = Math.abs(this.quantity);
        this.price = sum.divide(new BigDecimal(this.quantity), 2);
    }

    void negateSum() {
        this.setSum(
                this.getSum().negate()
        );
    }

    void negateQuantity() {
        this.setQuantity(
                Math.negateExact(
                        this.getQuantity() ) );
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "DocumentDetail{" +
              //  "id=" + getId() +
                ", product=" + product.getName() +
                ", quantity=" + quantity +
                ", price=" + price +
                ", sum=" + sum +
                '}';
    }
}
