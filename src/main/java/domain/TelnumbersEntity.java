package domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "telnumbers")
public class TelnumbersEntity extends BasePersistable implements Serializable {

    private String value;
    private boolean important;
    private ContactsEntity contact;

    @Basic
    @Column(name = "Value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "Important")
    public boolean getImportant() {
        return important;
    }

    public void setImportant(boolean primary) {
        this.important = primary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TelnumbersEntity that = (TelnumbersEntity) o;

        if (id != that.id) return false;
        if (important != that.important) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (important ? 1 : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ContactsID", referencedColumnName = "ID", nullable = false)
    public ContactsEntity getContact() {
        return contact;
    }

    public void setContact(ContactsEntity contact) {
        this.contact = contact;
    }
}
