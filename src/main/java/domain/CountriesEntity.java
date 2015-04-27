package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "countries")
public class CountriesEntity implements Serializable {
    private String id;
    private String germanName;
    private String englishName;
    private Collection<ContactsEntity> contactsesById;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

        CountriesEntity that = (CountriesEntity) o;

        if (englishName != null ? !englishName.equals(that.englishName) : that.englishName != null) return false;
        if (germanName != null ? !germanName.equals(that.germanName) : that.germanName != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (germanName != null ? germanName.hashCode() : 0);
        result = 31 * result + (englishName != null ? englishName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CountriesEntity{" +
                "id=" + id + ", " +
                ", germanName='" + germanName + '\'' +
                ", englishName='" + englishName + '\'' +
                "}";
    }

    @OneToMany(mappedBy = "countriesByCountriesId")
    public Collection<ContactsEntity> getContactsesById() {
        return contactsesById;
    }

    public void setContactsesById(Collection<ContactsEntity> contactsesById) {
        this.contactsesById = contactsesById;
    }
}
