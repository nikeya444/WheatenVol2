package ua.dp.wheaten.site.root.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 24.03.15
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "USERS")
public class User extends PersistableObjectAudit {

    private String login;
    private String passw;
    private String email;



    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
