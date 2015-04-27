package domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "speaks")
@AssociationOverrides({
        @AssociationOverride(name = "pk.contactsByContactsPersonId", joinColumns = @JoinColumn(name = "ContactsPersonID")),
        @AssociationOverride(name = "pk.languagesByLanguagesId", joinColumns = @JoinColumn(name = "LanguagesID")) })
public class SpeaksEntity implements Serializable {

    private SpeaksEntityId pk = new SpeaksEntityId();

    @EmbeddedId
    public SpeaksEntityId getPk() {
        return pk;
    }

    public void setPk(SpeaksEntityId pk) {
        this.pk = pk;
    }

    @Transient
    public ContactsEntity getContactsByContactsPersonId() {
        return pk.getContactsByContactsPersonId();
    }

    public void setContactsByContactsPersonId(ContactsEntity contactsByContactsPersonId) {
        pk.setContactsByContactsPersonId(contactsByContactsPersonId);
    }

    @Transient
    public LanguagesEntity getLanguagesByLanguagesId() {
        return pk.getLanguagesByLanguagesId();
    }

    public void setLanguagesByLanguagesId(LanguagesEntity languagesByLanguagesId) {
        pk.setLanguagesByLanguagesId(languagesByLanguagesId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpeaksEntity that = (SpeaksEntity) o;

        if (pk != null ? !pk.equals(that.pk) : that.pk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return pk != null ? pk.hashCode() : 0;
    }
}
