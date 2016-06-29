package ua.dp.wheaten.site.root.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

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
public class DocumentDetail extends PersistableObjectAudit  {

    public DocumentDetail() {
    }

    public DocumentDetail(Product product, Integer quantity, BigDecimal sum, Storage storage) {
        this.product = product;
        this.quantity = quantity;
        this.sum = sum;
        this.storage = storage;
    }

    public DocumentDetail(Product product, Integer quantity, BigDecimal sum, Document document, Storage storage) {
        this.product = product;
        this.quantity = quantity;
        this.sum = sum;
        this.document = document;
        this.storage = storage;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    @JsonProperty(value = "productId")
    @NotNull(message = "Product must be selected")
    private Product product;

    @Column(name = "QUANTITY")
    @JsonProperty(value = "quantity")
    @NotNull(message = "Quantity must be determined")
    private Integer quantity;

    @Column(name = "SUMM")
    @NotNull(message = "Sum must be determined")
    private BigDecimal sum;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID")
    private Document document;

    @ManyToOne
    @JoinColumn(name = "STORAGE_ID")
    @NotNull(message = "Storage must be selected")
    private Storage storage;

    @PostLoad
    private void abs() {
    //    if (this.document.getType() == Document.Type.MOVEMENT) return;
        this.sum = this.sum.abs();
        this.quantity = Math.abs(this.quantity);
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
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof DocumentDetail)) return false;
        DocumentDetail obj = (DocumentDetail) o;
        return this.getId().equals(obj.getId());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "DocumentDetail{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", sum=" + sum +
                ", storage=" + storage +
                "} " + System.identityHashCode(this);
    }
}
