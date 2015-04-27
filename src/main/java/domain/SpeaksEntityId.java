package domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Joyce on 24.02.2015.
 */
@Embeddable
public class SpeaksEntityId implements Serializable {

    private ContactsEntity contactsByContactsPersonId;
    private LanguagesEntity languagesByLanguagesId;

    @ManyToOne
    public ContactsEntity getContactsByContactsPersonId() {
        return contactsByContactsPersonId;
    }

    public void setContactsByContactsPersonId(ContactsEntity contactsByContactsPersonId) {
        this.contactsByContactsPersonId = contactsByContactsPersonId;
    }

    @ManyToOne
    public LanguagesEntity getLanguagesByLanguagesId() {
        return languagesByLanguagesId;
    }

    public void setLanguagesByLanguagesId(LanguagesEntity languagesByLanguagesId) {
        this.languagesByLanguagesId = languagesByLanguagesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpeaksEntityId that = (SpeaksEntityId) o;

        if (contactsByContactsPersonId != null ? !contactsByContactsPersonId.equals(that.contactsByContactsPersonId) : that.contactsByContactsPersonId != null)
            return false;
        if (languagesByLanguagesId != null ? !languagesByLanguagesId.equals(that.languagesByLanguagesId) : that.languagesByLanguagesId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactsByContactsPersonId != null ? contactsByContactsPersonId.hashCode() : 0;
        result = 31 * result + (languagesByLanguagesId != null ? languagesByLanguagesId.hashCode() : 0);
        return result;
    }
}
