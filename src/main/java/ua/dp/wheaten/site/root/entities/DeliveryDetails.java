package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 23.08.15
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name= "DELIVERY_DETAILS")
public class DeliveryDetails extends PersistableObjectAudit {

    @ManyToOne
    @JoinColumn(name = "SENDER_DEPARTMENT_ID")
    private DeliveryDepartment senderDepartment;

    @Column(name = "SENDER_INFO")
    private String senderInfo;

    @ManyToOne
    @JoinColumn(name = "RECIPIENT_DEPARTMENT_ID")
    private DeliveryDepartment recipientDepartment;

    @Column(name = "RECIPIENT_INFO")
    private String recipientInfo;

    @Column(name = "PHONE_NUMBER")
    private String recipientPhoneNumber;

    public DeliveryDepartment getSenderDepartment() {
        return senderDepartment;
    }

    public void setSenderDepartment(DeliveryDepartment senderDepartment) {
        this.senderDepartment = senderDepartment;
    }

    public DeliveryDepartment getRecipientDepartment() {
        return recipientDepartment;
    }

    public void setRecipientDepartment(DeliveryDepartment recipientDepartment) {
        this.recipientDepartment = recipientDepartment;
    }

    public String getSenderInfo() {
        return senderInfo;
    }

    public void setSenderInfo(String senderInfo) {
        this.senderInfo = senderInfo;
    }

    public String getRecipientInfo() {
        return recipientInfo;
    }

    public void setRecipientInfo(String recipientInfo) {
        this.recipientInfo = recipientInfo;
    }
}
