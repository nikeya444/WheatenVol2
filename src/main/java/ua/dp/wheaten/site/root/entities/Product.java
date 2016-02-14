package ua.dp.wheaten.site.root.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ua.dp.wheaten.site.web.jackson.DomainObjectDeserializer;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 30.08.15
 * Time: 22:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "PRODUCT")
@JsonDeserialize(using = DomainObjectDeserializer.class)
public class Product extends PersistableObject implements Convertable {

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_TYPE_ID")
    private ProductType productType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String createStringRepresentation() {
        return this.getName();
    }
}
