package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 30.08.15
 * Time: 21:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "PHONES")
public class Phone extends PersistableObjectAudit {

    @Column(name = "CODE")
    private String code;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "FULL_NUMBER")
    private String fullNumber;

    @ManyToOne
    @JoinColumn(name = "PARTNER_ID")
    private Partner partner;

    @PrePersist
    @PreUpdate
    private void populateFullnumber() {
        this.fullNumber = this.code + this.number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber(String fullNumber) {
        this.fullNumber = fullNumber;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}
