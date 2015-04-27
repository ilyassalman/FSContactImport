package domain.ConverterComparable;

import domain.LanguagesEntity;

/**
 * Created by Lukas on 27.04.2015.
 */
public class LanguageEntityComparable extends ConverterComparable<LanguagesEntity> {
    public LanguageEntityComparable(LanguagesEntity entityToCompare) {
        super(entityToCompare);
    }

    @Override
    public String getTextToCompare() {
        return entityToCompare.getEnglishName();
    }
}
