package ua.dp.wheaten.site.root.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 22.08.15
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "CITIES")
public class City extends PersistableObject {

    @Column(name = "CITY_NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    @JsonIgnore
    private Region region;

    public City() {
    }

    public City(String city) {
        this.name = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String city) {
        this.name = city;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
