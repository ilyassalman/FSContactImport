package domain;

import org.hibernate.LazyInitializationException;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "events")
public class EventsEntity extends BasePersistable implements Serializable {
    private String title;
    private Timestamp startDate;
    private Timestamp endDate;
    private String location;
    private String description;
    private String state;
    private byte checklistShown;
    private Collection<ContactvisitsEntity> contactvisitsesById;
    private ContactsEntity contactsByContactPerson;
    private EventcategoriesEntity eventcategoriesByEventCategorieId;
    private ProjectEntity projectByProjectId;
    private UsersEntity usersByResponsible;
    private Collection<UserworksEntity> userworksesById;

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "StartDate")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "EndDate")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "Location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "ChecklistShown")
    public byte getChecklistShown() {
        return checklistShown;
    }

    public void setChecklistShown(byte checklistShown) {
        this.checklistShown = checklistShown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventsEntity that = (EventsEntity) o;

        if (checklistShown != that.checklistShown) return false;
        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (int) checklistShown;
        return result;
    }

    @Override
    public String toString() {
        String s = "EventsEntity{" +
                "id=" + id + ", " +
                "title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                "} + Relationships: {" +
                "Contact-ID: ";
        if (getContactsByContactPerson() == null) {
            s += "null ";
        } else {
            s += getContactsByContactPerson().getId();
        }
        s += " ,Eventcategory-ID: ";
        try {
            if (getEventcategoriesByEventCategorieId() == null) {
                s += "null";
            } else {
                s += getEventcategoriesByEventCategorieId().getId();
            }
        } catch (LazyInitializationException e) {
            s += "LazyInitializationException";
        }
        s += "}";

        return s;
    }

    @OneToMany(mappedBy = "pk.eventsByEventId")
    public Collection<ContactvisitsEntity> getContactvisitsesById() {
        return contactvisitsesById;
    }

    public void setContactvisitsesById(Collection<ContactvisitsEntity> contactvisitsesById) {
        this.contactvisitsesById = contactvisitsesById;
    }

    @ManyToOne
    @JoinColumn(name = "ContactPerson", referencedColumnName = "ID", nullable = true)
    public ContactsEntity getContactsByContactPerson() {
        return contactsByContactPerson;
    }

    public void setContactsByContactPerson(ContactsEntity contactsByContactPerson) {
        this.contactsByContactPerson = contactsByContactPerson;
    }

    @ManyToOne
    @JoinColumn(name = "EventCategorieID", referencedColumnName = "ID", nullable = false)
    public EventcategoriesEntity getEventcategoriesByEventCategorieId() {
        return eventcategoriesByEventCategorieId;
    }

    public void setEventcategoriesByEventCategorieId(EventcategoriesEntity eventcategoriesByEventCategorieId) {
        this.eventcategoriesByEventCategorieId = eventcategoriesByEventCategorieId;
    }

    @ManyToOne
    @JoinColumn(name = "ProjectID", referencedColumnName = "ID")
    public ProjectEntity getProjectByProjectId() {
        return projectByProjectId;
    }

    public void setProjectByProjectId(ProjectEntity projectByProjectId) {
        this.projectByProjectId = projectByProjectId;
    }

    @ManyToOne
    @JoinColumn(name = "Responsible", referencedColumnName = "ID")
    public UsersEntity getUsersByResponsible() {
        return usersByResponsible;
    }

    public void setUsersByResponsible(UsersEntity usersByResponsible) {
        this.usersByResponsible = usersByResponsible;
    }

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    public Collection<UserworksEntity> getUserworksesById() {
        return userworksesById;
    }

    public void setUserworksesById(Collection<UserworksEntity> userworksesById) {
        this.userworksesById = userworksesById;
    }
}
