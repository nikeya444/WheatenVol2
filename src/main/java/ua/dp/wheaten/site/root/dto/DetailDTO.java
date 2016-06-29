package ua.dp.wheaten.site.root.dto;

import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.entities.Storage;
import ua.dp.wheaten.site.root.validation.groups.DefaultGroup;
import ua.dp.wheaten.site.root.validation.groups.InGroup;
import ua.dp.wheaten.site.root.validation.groups.MovementGroup;
import ua.dp.wheaten.site.root.validation.groups.OutGroup;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by kkm on 21.06.2016.
 */
public class DetailDTO {
    @NotNull(groups = DefaultGroup.class)
    private Product product;

    @NotNull(groups = DefaultGroup.class)
    private Integer quantity;
    @NotNull(groups = {InGroup.class, OutGroup.class})
    private BigDecimal sum;
    @NotNull(groups = DefaultGroup.class)
    private Storage storage;
    @NotNull(groups = MovementGroup.class)
    private Storage storage2;

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

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage2() {
        return storage2;
    }

    public void setStorage2(Storage storage2) {
        this.storage2 = storage2;
    }

    @Override
    public String toString() {
        return "DetailForm{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", sum=" + sum +
                ", storage=" + storage +
                ", storage2=" + storage2 +
                '}';
    }
}
