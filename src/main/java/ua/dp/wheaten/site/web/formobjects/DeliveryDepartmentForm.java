package ua.dp.wheaten.site.web.formobjects;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 01.09.15
 * Time: 18:54
 * To change this template use File | Settings | File Templates.
 */
public class DeliveryDepartmentForm {

    private String city;
    private String deliveryCompany;
    private Integer numberOfDepartment;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public Integer getNumberOfDepartment() {
        return numberOfDepartment;
    }

    public void setNumberOfDepartment(Integer numberOfDepartment) {
        this.numberOfDepartment = numberOfDepartment;
    }

    @Override
    public String toString() {
        return "DeliveryDepartmentForm{" +
                "city='" + city + '\'' +
                ", deliveryCompany='" + deliveryCompany + '\'' +
                ", numberOfDepartment=" + numberOfDepartment +
                '}';
    }
}
