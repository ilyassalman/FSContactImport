package repositories;

import domain.OrganisationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dominik on 26.04.2015.
 */
public interface OrganisationRepository extends JpaRepository<OrganisationsEntity, Integer> {
}
