package repositories;

import domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dominik on 26.04.2015.
 */
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
