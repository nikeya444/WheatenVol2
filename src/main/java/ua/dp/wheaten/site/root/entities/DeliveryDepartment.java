package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 23.08.15
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "DELIVERY_DEPARTMENTS")
public class DeliveryDepartment extends PersistableObjectAudit {
    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private City city;

    @ManyToOne
    @JoinColumn(name = "DELIVERY_COMPANY_ID")
    private DeliveryCompany company;

    @Column(name = "NUMBER_OF_DEPARTMENT")
    private Integer numberOfDepartment;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public DeliveryCompany getCompany() {
        return company;
    }

    public void setCompany(DeliveryCompany company) {
        this.company = company;
    }

    public Integer getNumberOfDepartment() {
        return numberOfDepartment;
    }

    public void setNumberOfDepartment(Integer numberOfDepartment) {
        this.numberOfDepartment = numberOfDepartment;
    }
}
