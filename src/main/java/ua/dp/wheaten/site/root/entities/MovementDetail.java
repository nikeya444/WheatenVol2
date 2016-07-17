package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kkm on 03.07.2016.
 */
@Entity
@Table(name = "MOVEMENT_DETAILS")
public class MovementDetail extends PersistableObjectAudit {

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_ID")
    private MovementDocument document;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "SUMM")
    private BigDecimal sum;

    @ManyToOne
    @JoinColumn(name = "STORAGE_SOURCE_ID")
    private Storage source;

    @ManyToOne
    @JoinColumn(name = "STORAGE_DEST_ID")
    private Storage destination;

    public MovementDocument getDocument() {
        return document;
    }

    public void setDocument(MovementDocument document) {
        this.document = document;
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

    public Storage getSource() {
        return source;
    }

    public void setSource(Storage source) {
        this.source = source;
    }

    public Storage getDestination() {
        return destination;
    }

    public void setDestination(Storage destination) {
        this.destination = destination;
    }

}
