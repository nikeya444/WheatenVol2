package ua.dp.wheaten.site.web.formobjects;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 14.05.15
 * Time: 13:52
 * To change this template use File | Settings | File Templates.
 */
public class PartnerForm {

    private String firstname;
    private String lastname;
    private String fathername;

    private String city;

    private List<PhoneForm> phoneForms;
    private List<DeliveryDepartmentForm> deliveryForms;


    public PartnerForm() {
        phoneForms = new LinkedList<>();
        phoneForms.add(new PhoneForm());
        deliveryForms = new LinkedList<>();
        deliveryForms.add(new DeliveryDepartmentForm());
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public List<PhoneForm> getPhoneForms() {
        return phoneForms;
    }

    public void setPhoneForms(List<PhoneForm> phoneForms) {
        this.phoneForms = phoneForms;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String address) {
        this.city = address;
    }

    public List<DeliveryDepartmentForm> getDeliveryForms() {
        return deliveryForms;
    }

    public void setDeliveryForms(List<DeliveryDepartmentForm> deliveryForms) {
        this.deliveryForms = deliveryForms;
    }
}
