package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 23.08.15
 * Time: 16:44
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "DELIVERY_DECLARATIONS")
public class DeliveryDeclaration extends PersistableObjectAudit {

    @Column(name = "NUMBER_OF_DECLARATION")
    private String numberOfDeclaration;

    @Column(name = "DEPARTURE_DATE")
    @Temporal(TemporalType.DATE)
    private Date departureDate;

    @Column(name = "ARRIVAL_DATE")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;

    @Column(name = "PRICE_OF_DELIVERY")
    private BigDecimal priceOfDelivery;

    @Column(name = "COD")
    private BigDecimal cod;         // cash on delivery

    @OneToOne
    @JoinColumn(name = "DELIVERY_DETAILS_ID")
    private DeliveryDetails details;

    public String getNumberOfDeclaration() {
        return numberOfDeclaration;
    }

    public void setNumberOfDeclaration(String numberOfDeclaration) {
        this.numberOfDeclaration = numberOfDeclaration;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public BigDecimal getPriceOfDelivery() {
        return priceOfDelivery;
    }

    public void setPriceOfDelivery(BigDecimal priceOfDelivery) {
        this.priceOfDelivery = priceOfDelivery;
    }

    public DeliveryDetails getDetails() {
        return details;
    }

    public void setDetails(DeliveryDetails details) {
        this.details = details;
    }

    public BigDecimal getCod() {
        return cod;
    }

    public void setCod(BigDecimal cod) {
        this.cod = cod;
    }
}
