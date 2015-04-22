package domain;

/**
 * Created by Lukas on 21.04.2015.
 */
public class Contact {
    private String title;
    private String name;
    private String surname;
    private String academicDegreeBefore;
    private String academicDegreeAfter;
    private String address;

    public void setPLZ(String PLZ) {
        this.PLZ = PLZ;
    }

    private String PLZ;
    private String homepage;
    private String info;
    private Organisation organisation;
    private String country;
    private boolean newsLetter;
    private String[] email;
    private String town;
    private String state;
    private String[] languages;
    private String[] number;

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
