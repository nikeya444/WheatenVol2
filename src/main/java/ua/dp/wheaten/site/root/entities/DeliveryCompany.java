package ua.dp.wheaten.site.root.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 22.08.15
 * Time: 22:48
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "DELIVERY_COMPANIES")
public class DeliveryCompany extends PersistableObject {
    @Column(name = "NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
