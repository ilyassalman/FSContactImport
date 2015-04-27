package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "roles")
public class RolesEntity extends BasePersistable implements Serializable {
    private String name;
    private Collection<UsersEntity> users;

    public final static int AdminId = 1;
    public final static String Admin = "Admin";
    public final static int EmployeeId = 3;
    public final static String Employee = "Employee";
    public final static String Contactadmin = "Contactadmin";
    public final static int ContactadminId = 2;
    public final static String Projectcontroller = "Projectcontroller";
    public final static int ProjectcontrollerId = 4;
    public final static int NewUserId = 6;
    public final static String NewUser = "New User";

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesEntity that = (RolesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RolesEntity{" +
                "id=" + id + ", " +
                "name='" + name + '\'' +
                '}';
    }

    @ManyToMany(mappedBy = "roles")
    public Collection<UsersEntity> getUsers() {
        return users;
    }

    public void setUsers(Collection<UsersEntity> users) {
        this.users = users;
    }
}
