package builder;

import domain.Contact;

/**
 * Created by Lukas on 21.04.2015.
 */
public class ContactBuilder implements AbstractBuilder<Contact> {

    private Contact contact;

    public ContactBuilder(Contact contact){
        this.contact = contact;
    }

    public ContactBuilder setTitle(String title){
        contact.setTitle(title);
        return this;
    }

    public ContactBuilder setName(String name){
        contact.setName(name);
        return this;
    }

    public ContactBuilder setSurname(String surname) {
        this.setSurname(surname);
        return this;
    }

    //TODO

    @Override
    public Contact build() {
        return null;
    }
}
