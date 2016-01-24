package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 31.08.15
 * Time: 0:39
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "OUTGOING_DOCUMENT")
public class OutgoingDocument extends Document {

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OutgoingDetail> details = new ArrayList<>();

    public List<OutgoingDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OutgoingDetail> details) {
        this.details = details;
    }

    public void addDetail(OutgoingDetail detail) {
        this.details.add(detail);
        detail.setDocument(this);
    }
}
