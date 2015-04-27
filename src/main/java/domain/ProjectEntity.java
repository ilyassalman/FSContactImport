package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "project")
public class ProjectEntity extends BasePersistable implements Serializable {
    private String name;
    private String projectnumber;
    private String description;
    private Collection<EventsEntity> eventsesById;
    private OrganisationsEntity organisationsByOrganisationsId;
    private ProjectstagesEntity projectstagesByProjectStage;

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Projectnumber")
    public String getProjectnumber() {
        return projectnumber;
    }

    public void setProjectnumber(String projectnumber) {
        this.projectnumber = projectnumber;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectEntity that = (ProjectEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (projectnumber != null ? !projectnumber.equals(that.projectnumber) : that.projectnumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (projectnumber != null ? projectnumber.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String s = "ProjectEntity{" +
                "id=" + id + ", " +
                "projectnumber='" + projectnumber + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                "} + Relationships: {" +
                "Organisation-ID: ";
        if(getOrganisationsByOrganisationsId() == null) {
            s += "null";
        } else {
            s += getOrganisationsByOrganisationsId().getId();
        }
            s += " ,ProjectStage-ID: ";
        if(getProjectstagesByProjectStage() == null) {
            s += "null";
        } else {
            s += getProjectstagesByProjectStage().getId();
        }
        s += "}";

        return s;
    }

    @OneToMany(mappedBy = "projectByProjectId")
    public Collection<EventsEntity> getEventsesById() {
        return eventsesById;
    }

    public void setEventsesById(Collection<EventsEntity> eventsesById) {
        this.eventsesById = eventsesById;
    }

    @ManyToOne
    @JoinColumn(name = "OrganisationsID", referencedColumnName = "ID")
    public OrganisationsEntity getOrganisationsByOrganisationsId() {
        return organisationsByOrganisationsId;
    }

    public void setOrganisationsByOrganisationsId(OrganisationsEntity organisationsByOrganisationsId) {
        this.organisationsByOrganisationsId = organisationsByOrganisationsId;
    }

    @ManyToOne
    @JoinColumn(name = "ProjectStage", referencedColumnName = "ID", nullable = false)
    public ProjectstagesEntity getProjectstagesByProjectStage() {
        return projectstagesByProjectStage;
    }

    public void setProjectstagesByProjectStage(ProjectstagesEntity projectstagesByProjectStage) {
        this.projectstagesByProjectStage = projectstagesByProjectStage;
    }
}
