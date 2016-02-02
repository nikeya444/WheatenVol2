package ua.dp.wheaten.site.root.dto;

import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.entities.Storage;

/**
 * Created by kkm on 28.01.2016.
 */
public class Remnant {
    private Product product;
    private Storage storage;
    private Long quantity;

    public Remnant() {
    }

    public Remnant(Product product, Long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Remnant(Product product, Storage storage, Long quantity) {
        this.product = product;
        this.storage = storage;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
