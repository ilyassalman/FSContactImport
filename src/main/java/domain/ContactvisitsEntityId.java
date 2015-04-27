package domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Joyce on 24.02.2015.
 */
@Embeddable
public class ContactvisitsEntityId implements Serializable {

    private ContactsEntity contactsByContactId;
    private EventsEntity eventsByEventId;

    @ManyToOne
    public ContactsEntity getContactsByContactId() {
        return contactsByContactId;
    }

    public void setContactsByContactId(ContactsEntity contactsByContactId) {
        this.contactsByContactId = contactsByContactId;
    }

    @ManyToOne
    public EventsEntity getEventsByEventId() {
        return eventsByEventId;
    }

    public void setEventsByEventId(EventsEntity eventsByEventId) {
        this.eventsByEventId = eventsByEventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactvisitsEntityId that = (ContactvisitsEntityId) o;

        if (contactsByContactId != null ? !contactsByContactId.equals(that.contactsByContactId) : that.contactsByContactId != null)
            return false;
        if (eventsByEventId != null ? !eventsByEventId.equals(that.eventsByEventId) : that.eventsByEventId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactsByContactId != null ? contactsByContactId.hashCode() : 0;
        result = 31 * result + (eventsByEventId != null ? eventsByEventId.hashCode() : 0);
        return result;
    }
}
