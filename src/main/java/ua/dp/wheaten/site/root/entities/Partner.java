package ua.dp.wheaten.site.root.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ua.dp.wheaten.site.web.jackson.DomainObjectDeserializer;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 24.03.15
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 */

@Entity
@NamedQuery(name = "Partner.getOne", query = "select p from Partner p where p.id = :id")
@Table(name = "PARTNERS")
@JsonDeserialize(using = DomainObjectDeserializer.class)
public class Partner extends PersistableObjectAudit {

    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "FATHERNAME")
    private String fathername;

    @OneToMany(mappedBy = "partner", fetch = FetchType.EAGER)
    private List<Phone> phones = new LinkedList<>();

    @ManyToMany
    @JoinTable(name = "COMPANY_DELIVERY_ADDRESSES",
            joinColumns = @JoinColumn(name = "PARTNER_ID"),
            inverseJoinColumns = @JoinColumn(name = "DELIVERY_DEPARTMENT_ID"))
    private List<DeliveryDepartment> deliveryDepartments = new LinkedList<>();

    public Partner() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String fname) {
        this.firstname = fname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lname) {
        this.lastname = lname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void addPhone(Phone phone) {
        this.phones.add(phone);
    }

    public List<DeliveryDepartment> getDeliveryDepartments() {
        return deliveryDepartments;
    }

    public void setDeliveryDepartments(List<DeliveryDepartment> deliveryDepartments) {
        this.deliveryDepartments = deliveryDepartments;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
