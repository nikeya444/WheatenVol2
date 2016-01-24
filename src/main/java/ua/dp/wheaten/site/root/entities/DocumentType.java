package ua.dp.wheaten.site.root.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 24.03.15
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "DOCUMENT_TYPES")
public class DocumentType extends PersistableObject {

    @Column(name = "DOCUMENT_TYPE")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DocumentType{" +
                "type='" + type + '\'' +
                '}';
    }
}
