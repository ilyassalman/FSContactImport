package repositories;

import domain.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dominik on 26.04.2015.
 */
public interface OrganisationRepository extends JpaRepository<Organisation, Integer> {
}
