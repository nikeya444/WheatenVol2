package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 12.05.15
 * Time: 1:03
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class PersistableObjectAudit extends PersistableObject {
    @Column(name = "INSERT_TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTimestamp;

    @Column(name = "UPDATE_TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTimestamp;

    @Column(name = "USER_NAME")
    private String username;

    @SuppressWarnings("unused")
    @PrePersist
    private void onIsert() {
        this.insertTimestamp = new Date();
        this.updateTimestamp = this.insertTimestamp;
    }

    @SuppressWarnings("unused")
    @PreUpdate
    private void onUpdate() {
        this.updateTimestamp = new Date();
    }

    public Date getInsertTimestamp() {
        return insertTimestamp;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    protected void setInsertTimestamp(Date insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    protected void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public String getUsername() {
        return username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }
}
