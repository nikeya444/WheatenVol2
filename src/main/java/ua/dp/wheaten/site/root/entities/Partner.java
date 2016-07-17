package ua.dp.wheaten.site.root.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Partner extends PersistableObjectAudit implements Convertable {

    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "FATHERNAME")
    private String fathername;

    @Column(name = "FULLNAME")
    private String fullname;

    @OneToMany(mappedBy = "partner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Phone> phones = new LinkedList<>();

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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    @PrePersist
    @PreUpdate
    private void populateFullnameField() {
        this.fullname = this.lastname + " " + this.firstname + " " + this.fathername;
    }

    @Override
    public String createStringRepresentation() {
        return this.fullname;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "fullname='" + fullname + '\'' +
                '}';
    }
}
