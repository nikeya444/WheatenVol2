package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime insertTimestamp;

    @Column(name = "UPDATE_TS")
    private LocalDateTime updateTimestamp;

    @Column(name = "USER_NAME")
    private String username;

    @SuppressWarnings("unused")
    @PrePersist
    private void onIsert() {
        this.insertTimestamp = LocalDateTime.now();
        this.updateTimestamp = this.insertTimestamp;
    }

    @SuppressWarnings("unused")
    @PreUpdate
    private void onUpdate() {
        this.updateTimestamp = LocalDateTime.now();
    }

    public LocalDateTime getInsertTimestamp() {
        return insertTimestamp;
    }

    public LocalDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    protected void setInsertTimestamp(LocalDateTime insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    protected void setUpdateTimestamp(LocalDateTime updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public String getUsername() {
        return username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }
}
