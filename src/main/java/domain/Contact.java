package domain;

import javax.persistence.*;

/**
 * Created by Lukas on 21.04.2015.
 */

@Entity
@Table(name = "Contacts")
public class Contact extends BasePersistable {

    @Column
    private String title;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String academicDegreeBefore;

    @Column
    private String academicDegreeAfter;

    @Column
    private String address;

    @Column
    private String PLZ;

    @Column
    private String homepage;

    @Column
    private String info;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "ID")
    private Organisation organisation;

    @Column
    private String country;

    @Column
    private boolean newsLetter;

    @Column
    private String[] email;

    @Column
    private String town;

    @Column
    private String state;

    @Column
    private String[] languages;

    @Column
    private String[] number;

    public void setPLZ(String PLZ) {
        this.PLZ = PLZ;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAcademicDegreeBefore(String academicDegreeBefore) {
        this.academicDegreeBefore = academicDegreeBefore;
    }

    public void setAcademicDegreeAfter(String academicDegreeAfter) {
        this.academicDegreeAfter = academicDegreeAfter;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNewsLetter(boolean newsLetter) {
        this.newsLetter = newsLetter;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public void setNumber(String[] number) {
        this.number = number;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }
}
