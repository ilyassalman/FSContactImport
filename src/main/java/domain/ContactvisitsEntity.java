package domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "contactvisits")
@AssociationOverrides({
        @AssociationOverride(name = "pk.contactsByContactId", joinColumns = @JoinColumn(name = "ContactID")),
        @AssociationOverride(name = "pk.eventsByEventId", joinColumns = @JoinColumn(name = "EventID")) })
public class ContactvisitsEntity implements Serializable {

    private ContactvisitsEntityId pk = new ContactvisitsEntityId();
    private VisitstatusEntity visitstatusByVisitStatusId;

    @EmbeddedId
    public ContactvisitsEntityId getPk() {
        return pk;
    }

    public void setPk(ContactvisitsEntityId pk) {
        this.pk = pk;
    }

    @ManyToOne
    @JoinColumn(name = "VisitStatusID", referencedColumnName = "ID", nullable = false)
    public VisitstatusEntity getVisitstatusByVisitStatusId() {
        return visitstatusByVisitStatusId;
    }

    public void setVisitstatusByVisitStatusId(VisitstatusEntity visitstatusByVisitStatusId) {
        this.visitstatusByVisitStatusId = visitstatusByVisitStatusId;
    }

    @Transient
    public ContactsEntity getContactsByContactId() {
        return pk.getContactsByContactId();
    }

    public void setContactsByContactId(ContactsEntity contactsByContactId) {
        pk.setContactsByContactId(contactsByContactId);
    }

    @Transient
    public EventsEntity getEventsByEventId() {
        return pk.getEventsByEventId();
    }

    public void setEventsByEventId(EventsEntity eventsByEventId) {
        pk.setEventsByEventId(eventsByEventId);
    }
}
