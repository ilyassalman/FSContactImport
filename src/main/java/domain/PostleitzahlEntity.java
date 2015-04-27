package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "postleitzahl")
public class PostleitzahlEntity extends BasePersistable implements Serializable {
    private int plz;
    private String name;
    private String bundesland;
    private Collection<ContactsEntity> contactsesById;

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PLZ")
    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    @Column(name = "Bundesland")
    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostleitzahlEntity that = (PostleitzahlEntity) o;

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

    @OneToMany(mappedBy = "postleitzahlByPlz", cascade = CascadeType.ALL)
    public Collection<ContactsEntity> getContactsesById() {
        return contactsesById;
    }

    public void setContactsesById(Collection<ContactsEntity> contactsesById) {
        this.contactsesById = contactsesById;
    }
}
