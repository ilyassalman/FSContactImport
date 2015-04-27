package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "eventcategories")
public class EventcategoriesEntity extends BasePersistable implements Serializable {
    private String name;
    private String color;
    private Collection<EventsEntity> eventsesById;

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventcategoriesEntity that = (EventcategoriesEntity) o;

        if (id != that.id) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EventcategoriesEntity{" +
                "id=" + id + ", " +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "eventcategoriesByEventCategorieId", fetch = FetchType.LAZY)
    public Collection<EventsEntity> getEventsesById() {
        return eventsesById;
    }

    public void setEventsesById(Collection<EventsEntity> eventsesById) {
        this.eventsesById = eventsesById;
    }
}
