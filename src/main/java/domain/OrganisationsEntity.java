package domain;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "organisations")
public class OrganisationsEntity extends BasePersistable implements Serializable {
    private String name;
    private String desc;
    private Collection<ContactsEntity> contactsesById;
    private Collection<ProjectEntity> projectsById;
    private int contactMembers;

    public OrganisationsEntity() {
        contactsesById = new ArrayList<>();
        projectsById = new ArrayList<>();
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Beschreibung")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganisationsEntity that = (OrganisationsEntity) o;

        if (id != that.id) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrganisationsEntity{" +
                "id=" + id + ", " +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    @Nullable
    @OneToMany(mappedBy = "organisationsByOrganisationsId" , cascade = CascadeType.ALL)
    public Collection<ContactsEntity> getContactsesById() {
        return contactsesById;
    }

    public void setContactsesById(Collection<ContactsEntity> contactsesById) {
        this.contactsesById = contactsesById;
    }

    @OneToMany(mappedBy = "organisationsByOrganisationsId")
    public Collection<ProjectEntity> getProjectsById() {
        return projectsById;
    }

    public void setProjectsById(Collection<ProjectEntity> projectsById) {
        this.projectsById = projectsById;
    }
    @Transient
    public int getContactMembers() {
        return contactMembers;
    }

    public void setContactMembers(int contactMembers) {
        this.contactMembers = contactMembers;
    }
}
