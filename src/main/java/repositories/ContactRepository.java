package repositories;

import domain.ContactsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dominik on 26.04.2015.
 */
public interface ContactRepository extends JpaRepository<ContactsEntity, Integer> {
}
