package ua.dp.wheaten.site.root.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 12.05.15
 * Time: 0:58
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class PersistableObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Version
    @Column(name = "VERSION")
    private Integer version;

    public Integer getId() {
        return id;
    }

    protected void setId(Integer pkey) {
        this.id = pkey;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersistableObject that = (PersistableObject) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
