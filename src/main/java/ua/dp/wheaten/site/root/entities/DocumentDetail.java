package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 12.05.15
 * Time: 22:39
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class DocumentDetail extends PersistableObjectAudit {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Transient
    private BigDecimal price;

    @Column(name = "SUMM")
    private BigDecimal sum;

    @PostLoad
    private void populatePrice() {
        price = sum.divide(new BigDecimal(quantity));
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

    @Override
    public String toString() {
        return "DocumentDetail{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", sum=" + sum +
                '}';
    }
}
