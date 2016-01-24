package ua.dp.wheaten.site.root.entities;

import ua.dp.wheaten.site.root.listeners.IncomingListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 31.08.15
 * Time: 0:11
 * To change this template use File | Settings | File Templates.
 */
//@EntityListeners(IncomingListener.class)
@Entity
@Table(name = "INCOMING_DOCUMENTS")
//@EntityListeners(value = {IncomingListener.class})
public class IncomingDocument extends Document {

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<IncomingDetail> details = new ArrayList<>();


    public List<IncomingDetail> getDetails() {
        return details;
    }

    public void setDetails(List<IncomingDetail> details) {
        this.details = details;
    }

    public void addDetail(IncomingDetail detail) {
        this.details.add(detail);
        detail.setDocument(this);
    }



    @Override
    public String toString() {
        return super.toString() +
                "details=" + details +
                '}';
    }
}
