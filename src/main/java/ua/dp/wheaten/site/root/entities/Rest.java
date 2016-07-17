package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by kkm on 04.07.2016.
 */
@Entity
@Table(name = "RESTS")
public class Rest extends PersistableObject {

    public Rest() {
    }

    public Rest(LocalDate restDate, Storage storage, Product product, Integer quantity, BigDecimal sum) {
        this.restDate = restDate;
        this.storage = storage;
        this.product = product;
        this.quantity = quantity;
        this.sum = sum;
    }

    @Column(name = "REST_DATE")
    private LocalDate restDate;

    @ManyToOne
    @JoinColumn(name = "STORAGE_ID")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "SUMM")
    private BigDecimal sum;

    public LocalDate getRestDate() {
        return restDate;
    }

    public void setRestDate(LocalDate restDate) {
        this.restDate = restDate;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
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
}
