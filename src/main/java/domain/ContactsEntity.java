package domain;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Joyce on 24.02.2015.
 */
@Entity
@Table(name = "contacts")
public class ContactsEntity extends BasePersistable implements Serializable {
    private String title;
    private String name;
    private String surname;
    private String academicDegreeBefore;
    private String academicDegreeAfter;
    private String address;
    private String state;
    private Timestamp createDate;
    private Timestamp updateDate;
    private String hompage;
    private String info;
    private Boolean newsletter;
    private Collection<AdditionalinformationEntity> additionalinformationsById;
    private Collection<EmailsEntity> emails;
    private Collection<TelnumbersEntity> telnumbers;
    private CountriesEntity countriesByCountriesId;
    private OrganisationsEntity organisationsByOrganisationsId;
    private PostleitzahlEntity postleitzahlByPlz;
    private Collection<ContactvisitsEntity> contactvisitsesById;
    private Collection<EventsEntity> eventsesById;
    private Collection<SpeaksEntity> speaksesById;
    private Collection<UsersEntity> usersesById;

    public ContactsEntity() {
        this.additionalinformationsById = new ArrayList<>();
        this.emails = new ArrayList<>();
        this.telnumbers = new ArrayList<>();
        this.contactvisitsesById = new ArrayList<>();
        this.eventsesById = new ArrayList<>();
        this.speaksesById = new ArrayList<>();
        this.usersesById = new ArrayList<>();
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        if (this.title != null)
            return title;
        else
            return "-";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Transient
    public String getDisplay(){
        String[] names = new String[]{academicDegreeBefore,title,name,surname,academicDegreeAfter};
        String display = "";
        for(String name:names){
            if(name != null) {
                display += name + " ";
            }
        }
        return display.trim();
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        if (this.name != null)
            return name;
        else
            return "-";
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Surname")
    public String getSurname() {
        if (this.surname != null) {
            return surname;
        } else
            return "-";
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "AcademicDegreeBefore")
    public String getAcademicDegreeBefore() {
        return academicDegreeBefore;
    }

    public void setAcademicDegreeBefore(String academicDegreeBefore) {
        if(academicDegreeBefore != null) {
            this.academicDegreeBefore = academicDegreeBefore;
        }
    }

    @Basic
    @Column(name = "AcademicDegreeAfter")
    public String getAcademicDegreeAfter() {
        if (this.academicDegreeAfter != null)
            return academicDegreeAfter;
        else
            return "-";
    }

    public void setAcademicDegreeAfter(String academicDegreeAfter) {
        if(academicDegreeAfter != null) {
            this.academicDegreeAfter = academicDegreeAfter;
        }
    }

    @Basic
    @Column(name = "Address")
    public String getAddress() {
        if (this.address != null)
            return address;
        else
            return "-";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "State")
    public String getState() {
        if (this.state != null)
        return state;
        else
            return "-";
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "CreateDate")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "UpdateDate")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "Hompage")
    public String getHompage() {
        if (this.hompage != null)
        return hompage;
        else
            return "-";
    }

    public void setHompage(String hompage) {
        this.hompage = hompage;
    }

    @Basic
    @Column(name = "Info")
    public String getInfo() {
        if (this.info != null)
            return info;
        else
            return "-";
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Transient
    public List<LanguagesEntity> getLanguages() {
        List<LanguagesEntity> languagesEntityList = new ArrayList<>();
        for (SpeaksEntity speaksEntity : getSpeaksesById()) {
            languagesEntityList.add(speaksEntity.getLanguagesByLanguagesId());
        }
        return languagesEntityList;
    }

    @Basic
    @Column(name = "Newsletter")
    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactsEntity that = (ContactsEntity) o;

        if (id != that.id) return false;
        if (academicDegreeAfter != null ? !academicDegreeAfter.equals(that.academicDegreeAfter) : that.academicDegreeAfter != null)
            return false;
        if (academicDegreeBefore != null ? !academicDegreeBefore.equals(that.academicDegreeBefore) : that.academicDegreeBefore != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (hompage != null ? !hompage.equals(that.hompage) : that.hompage != null) return false;
        if (info != null ? !info.equals(that.info) : that.info != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (newsletter != null ? !newsletter.equals(that.newsletter) : that.newsletter != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (academicDegreeBefore != null ? academicDegreeBefore.hashCode() : 0);
        result = 31 * result + (academicDegreeAfter != null ? academicDegreeAfter.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (hompage != null ? hompage.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (newsletter != null ? newsletter.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String s = "ContactsEntity{" +
                "id=" + id + ", " +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", academicDegreeBefore='" + academicDegreeBefore + '\'' +
                ", academicDegreeAfter='" + academicDegreeAfter + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", hompage='" + hompage + '\'' +
                ", info='" + info + '\'' +
                ", newsletter=" + newsletter +
                "} + Relationships: {" +
                "Organisation-ID: ";

        if (getOrganisationsByOrganisationsId() == null) {
            s += "null";
        } else {
            s += getOrganisationsByOrganisationsId().getId();
        }

        s += " ,Country-ID: ";

        if (getCountriesByCountriesId() == null)
            s += "null";
        else
            s += getCountriesByCountriesId().getId();

        s += "}";
        return s;
    }

    @OneToMany(orphanRemoval = true, mappedBy = "contactsByContactId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Collection<AdditionalinformationEntity> getAdditionalinformationsById() {
        return additionalinformationsById;
    }

    public void setAdditionalinformationsById(Collection<AdditionalinformationEntity> additionalinformationsById) {
        this.additionalinformationsById = additionalinformationsById;
    }


    @OneToMany(mappedBy = "contact", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Collection<EmailsEntity> getEmails() {
        return emails;
    }

    public void setEmails(Collection<EmailsEntity> emails) {
        this.emails = emails;
    }

    @OneToMany(mappedBy = "contact", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Collection<TelnumbersEntity> getTelnumbers() {
        return telnumbers;
    }

    public void setTelnumbers(Collection<TelnumbersEntity> telnumbers) {
        this.telnumbers = telnumbers;
    }

    @ManyToOne
    @JoinColumn(name = "CountriesID", referencedColumnName = "ID")
    public CountriesEntity getCountriesByCountriesId() {
        return countriesByCountriesId;
    }

    public void setCountriesByCountriesId(CountriesEntity countriesByCountriesId) {
        this.countriesByCountriesId = countriesByCountriesId;
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
    @JoinColumn(name = "PLZ", referencedColumnName = "ID")
    public PostleitzahlEntity getPostleitzahlByPlz() {
        return postleitzahlByPlz;
    }

    public void setPostleitzahlByPlz(PostleitzahlEntity postleitzahlByPlz) {
        this.postleitzahlByPlz = postleitzahlByPlz;
    }

    @OneToMany(mappedBy = "pk.contactsByContactId")
    public Collection<ContactvisitsEntity> getContactvisitsesById() {
        return contactvisitsesById;
    }

    public void setContactvisitsesById(Collection<ContactvisitsEntity> contactvisitsesById) {
        this.contactvisitsesById = contactvisitsesById;
    }

    @OneToMany(mappedBy = "contactsByContactPerson")
    public Collection<EventsEntity> getEventsesById() {
        return eventsesById;
    }

    public void setEventsesById(Collection<EventsEntity> eventsesById) {
        this.eventsesById = eventsesById;
    }

    @BatchSize(size = 10)
    @OneToMany(orphanRemoval = true, mappedBy = "pk.contactsByContactsPersonId", cascade = CascadeType.ALL)
    public Collection<SpeaksEntity> getSpeaksesById() {
        return speaksesById;
    }

    public void setSpeaksesById(Collection<SpeaksEntity> speaksesById) {
        this.speaksesById = speaksesById;
    }



    @OneToMany(mappedBy = "contactsByContactsId", fetch = FetchType.EAGER)
    public Collection<UsersEntity> getUsersesById() {
        return usersesById;
    }

    public void setUsersesById(Collection<UsersEntity> usersesById) {
        this.usersesById = usersesById;
    }

    @Transient
    public EmailsEntity getImportantMails() {
        for (Iterator<EmailsEntity> iterator = getEmails().iterator(); iterator.hasNext(); ) {
            EmailsEntity mail =  iterator.next();
            if(mail.getImportant())
                return mail;
        }
        return null;
    }

    @Transient
    public List<EmailsEntity> getNotImportantMails() {
        List<EmailsEntity> mails = new ArrayList<>();
        for (Iterator<EmailsEntity> iterator = getEmails().iterator(); iterator.hasNext(); ) {
            EmailsEntity mail =  iterator.next();
            if(!mail.getImportant())
                mails.add(mail);
        }
        return mails;
    }

    @Transient
    public TelnumbersEntity getImportantTelnumbers() {
        for (Iterator<TelnumbersEntity> iterator = getTelnumbers().iterator(); iterator.hasNext(); ) {
            TelnumbersEntity telnumbersEntity = (TelnumbersEntity) iterator.next();
            if(telnumbersEntity.getImportant())
                return telnumbersEntity;
        }
        return null;
    }

    @Transient
    public List<TelnumbersEntity> getNotImportantTelnumbers() {
        List<TelnumbersEntity> tels = new ArrayList<>();
        for (Iterator<TelnumbersEntity> iterator = getTelnumbers().iterator(); iterator.hasNext(); ) {
            TelnumbersEntity telnumbersEntity = (TelnumbersEntity) iterator.next();
            if(!telnumbersEntity.getImportant())
                tels.add(telnumbersEntity);
        }
        return tels;
    }
}
