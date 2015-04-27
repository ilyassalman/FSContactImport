package domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Dominik on 20.11.2014.
 */
@Entity
@Table(name = "users")
public class UsersEntity extends BasePersistable implements Serializable {
    private String username;
    private String password;
    private Double plannedHours;
    private Boolean deactivated;
    private Collection<EventsEntity> eventsesById;
    private Collection<RolesEntity> roles;
    private ContactsEntity contactsByContactsId;
    private Collection<UserworksEntity> userworksesById;
    private Collection<WorkingtimesEntity> workingtimesesById;

    public UsersEntity() {
        roles = new ArrayList<>();
        userworksesById = new ArrayList<>();
        workingtimesesById = new ArrayList<>();
    }

    @Basic
    @Column(name = "Username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "PlannedHours")
    public Double getPlannedHours() {
        return plannedHours;
    }

    public void setPlannedHours(Double plannedHours) {
        this.plannedHours = plannedHours;
    }

    @Basic
    @Column(name = "Deactivated")
    public Boolean getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(Boolean deactivated) {
        this.deactivated = deactivated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (plannedHours != null ? plannedHours.hashCode() : 0);
        result = 31 * result + (deactivated != null ? deactivated.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String s = "UsersEntity{" +
                "id=" + id + ", " +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", plannedHours=" + plannedHours +
                "} + Relationships: {" +
                "Contact-ID: ";
        if(getContactsByContactsId() == null) {
            s += "null";
        } else {
            s += getContactsByContactsId().getId();
        }
        s += "}";

        return s;
    }

    @OneToMany(mappedBy = "usersByResponsible")
    public Collection<EventsEntity> getEventsesById() {
        return eventsesById;
    }

    public void setEventsesById(Collection<EventsEntity> eventsesById) {
        this.eventsesById = eventsesById;
    }

    @ManyToMany
    @JoinTable(name = "permission", joinColumns = {@JoinColumn(name = "UserId", referencedColumnName = "ID")},
    inverseJoinColumns = {@JoinColumn(name = "RoleId", referencedColumnName = "ID")})
    public Collection<RolesEntity> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RolesEntity> roles) {
        this.roles = roles;
    }

    @ManyToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "ContactsID", referencedColumnName = "ID")
    public ContactsEntity getContactsByContactsId() {
        return contactsByContactsId;
    }

    public void setContactsByContactsId(ContactsEntity contactsByContactsId) {
        this.contactsByContactsId = contactsByContactsId;
    }

    @OneToMany(mappedBy = "user")
    public Collection<UserworksEntity> getUserworksesById() {
        return userworksesById;
    }

    public void setUserworksesById(Collection<UserworksEntity> userworksesById) {
        this.userworksesById = userworksesById;
    }

    @OneToMany(mappedBy = "usersByUserId", orphanRemoval = true, cascade = CascadeType.ALL)
    public Collection<WorkingtimesEntity> getWorkingtimesesById() {
        return workingtimesesById;
    }

    public void setWorkingtimesesById(Collection<WorkingtimesEntity> workingtimesesById) {
        this.workingtimesesById = workingtimesesById;
    }

    public boolean hasRole(int roleId){
        for (RolesEntity item : roles){
            if(item.getId() == roleId){
                return true;
            }
        }
        return false;
    }

    public boolean removeRole(int roleId){
        for (RolesEntity item : roles){
            if(item.getId() == roleId){
                roles.remove(item);
                return true;
            }
        }
        return false;
    }
}
