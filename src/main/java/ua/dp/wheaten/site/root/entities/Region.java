package ua.dp.wheaten.site.root.entities;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 04.09.15
 * Time: 22:42
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "REGIONS")
@Cacheable
public class Region extends PersistableObject {

    @Column(name = "REGION_NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
