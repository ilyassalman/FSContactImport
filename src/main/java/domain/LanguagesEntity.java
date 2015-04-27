package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "languages")
public class LanguagesEntity extends BasePersistable implements Serializable {
    private String germanName;
    private String englishName;
    private Collection<SpeaksEntity> speaksesById;

    @Basic
    @Column(name = "GermanName")
    public String getGermanName() {
        return germanName;
    }

    public void setGermanName(String germanName) {
        this.germanName = germanName;
    }

    @Basic
    @Column(name = "EnglishName")
    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguagesEntity that = (LanguagesEntity) o;

        if (id != that.id) return false;
        if (englishName != null ? !englishName.equals(that.englishName) : that.englishName != null) return false;
        if (germanName != null ? !germanName.equals(that.germanName) : that.germanName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (germanName != null ? germanName.hashCode() : 0);
        result = 31 * result + (englishName != null ? englishName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LanguagesEntity{" +
                "id=" + id + ", " +
                "englishName='" + englishName + '\'' +
                ", germanName='" + germanName + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "pk.languagesByLanguagesId")
    public Collection<SpeaksEntity> getSpeaksesById() {
        return speaksesById;
    }

    public void setSpeaksesById(Collection<SpeaksEntity> speaksesById) {
        this.speaksesById = speaksesById;
    }
}
