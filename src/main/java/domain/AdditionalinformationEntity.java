package domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "additionalinformation")
public class AdditionalinformationEntity extends BasePersistable implements Serializable {
    private String name;
    private String value;
    private ContactsEntity contactsByContactId;

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof AdditionalinformationEntity) {
            AdditionalinformationEntity additionalinformationEntity = (AdditionalinformationEntity)o;
            return additionalinformationEntity.getId() == this.getId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (contactsByContactId != null ? contactsByContactId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String s = "AdditionalinformationEntity{" +
                "id=" + id + ", " +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                "} + Relationships: {" +
                "Contact-ID: ";
        if(getContactsByContactId() == null) {
            s += "null} ";
        } else {
            s += getContactsByContactId().getId() +
                    "}";
        }
        return s;
    }

    @ManyToOne
    @JoinColumn(name = "ContactID", referencedColumnName = "ID", nullable = false)
    public ContactsEntity getContactsByContactId() {
        return contactsByContactId;
    }

    public void setContactsByContactId(ContactsEntity contactsByContactId) {
        this.contactsByContactId = contactsByContactId;
    }
}
