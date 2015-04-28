package repositories;

import domain.PostleitzahlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lukas on 28.04.2015.
 */
public interface PLZRepository extends JpaRepository<PostleitzahlEntity, Integer> {
}
