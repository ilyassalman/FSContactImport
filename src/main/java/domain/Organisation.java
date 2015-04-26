package domain;

import javax.persistence.*;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Lukas on 21.04.2015.
 */

@Entity
@Table
public class Organisation extends BasePersistable {

    @Column
    private String name;

    @OneToMany(targetEntity = domain.Contact.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection contacts;

    public Organisation(String name) {
        contacts = new ArrayList();
        this.name = name;
    }

    public Organisation() {
        contacts = new ArrayList();
    }


    @Override
    public boolean equals(Object obj) {
        try {
            return name.toUpperCase().trim().equals(((Organisation) obj).name.toUpperCase().trim());
        } catch (Exception e) {
            return false;
        }

    }

    public Collection getContacts() {
        return contacts;
    }

    public void setContacts(Collection contacts) {
        this.contacts = contacts;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.toUpperCase().trim().hashCode();
    }

    public String getName() {
        if(name == null){
            return "";
        }
        return name;
    }
}
