package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "visitstatus")
public class VisitstatusEntity extends BasePersistable implements Serializable {
    private String name;
    private Collection<ContactvisitsEntity> contactvisitsesById;

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

        VisitstatusEntity that = (VisitstatusEntity) o;

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
        return "VisitstatusEntity{" +
                "id=" + id + ", " +
                "name='" + name + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "visitstatusByVisitStatusId")
    public Collection<ContactvisitsEntity> getContactvisitsesById() {
        return contactvisitsesById;
    }

    public void setContactvisitsesById(Collection<ContactvisitsEntity> contactvisitsesById) {
        this.contactvisitsesById = contactvisitsesById;
    }
}
