package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 31.08.15
 * Time: 0:30
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "MOVEMENT_DOCUMENTS")
public class MovementDocument extends Document {

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MovementDetail> details = new ArrayList<>();

    public List<MovementDetail> getDetails() {
        return details;
    }

    public void setDetails(List<MovementDetail> details) {
        this.details = details;
    }
}
