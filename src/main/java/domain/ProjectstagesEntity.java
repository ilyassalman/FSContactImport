package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "projectstages")
public class ProjectstagesEntity extends BasePersistable implements Serializable {
    private String name;
    private Collection<ProjectEntity> projectsById;

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectstagesEntity that = (ProjectstagesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProjectstagesEntity{" +
                "id=" + id + ", " +
                "name='" + name + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "projectstagesByProjectStage")
    public Collection<ProjectEntity> getProjectsById() {
        return projectsById;
    }

    public void setProjectsById(Collection<ProjectEntity> projectsById) {
        this.projectsById = projectsById;
    }
}
