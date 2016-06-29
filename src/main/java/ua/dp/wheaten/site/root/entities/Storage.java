package ua.dp.wheaten.site.root.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 30.08.15
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "STORAGES")
public class Storage extends PersistableObject {
    @Column(name = "STORAGE_NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "name='" + name + '\'' +
                '}';
    }
}
