package repositories;

import domain.LanguagesEntity;
import domain.SpeaksEntity;
import domain.SpeaksEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lukas on 27.04.2015.
 */
public interface LanguageRepository extends JpaRepository<LanguagesEntity, Integer> {
}
