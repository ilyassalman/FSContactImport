package domain;

/**
 * Created by Lukas on 21.04.2015.
 */
public class Contact {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAcademicDegreeBefore() {
        return academicDegreeBefore;
    }

    public void setAcademicDegreeBefore(String academicDegreeBefore) {
        this.academicDegreeBefore = academicDegreeBefore;
    }

    public String getAcademicDegreeAfter() {
        return academicDegreeAfter;
    }

    public void setAcademicDegreeAfter(String academicDegreeAfter) {
        this.academicDegreeAfter = academicDegreeAfter;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public long getPLZ() {
        return PLZ;
    }

    public void setPLZ(long PLZ) {
        this.PLZ = PLZ;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isNewsLetter() {
        return newsLetter;
    }

    public void setNewsLetter(boolean newsLetter) {
        this.newsLetter = newsLetter;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    private String title;
    private String name;
    private String surname;
    private String academicDegreeBefore;
    private String academicDegreeAfter;
    private String address;
    private long PLZ;
    private String homepage;
    private String info;
    private Organisation organisation;
    private String country;
    private boolean newsLetter;
    private String town;
    private String state;
    private String[] languages;
    private String[] number;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
