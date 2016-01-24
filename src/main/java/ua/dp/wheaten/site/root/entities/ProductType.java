package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 24.03.15
 * Time: 14:56
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "PRODUCT_TYPES")
public class ProductType extends PersistableObject {

    @Column(name = "TYPE_NAME")
    private String type;

    @Column(name = "DESCRIPTION")
    private String description;

    public ProductType() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
