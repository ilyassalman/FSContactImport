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
        return entityToCompare.getGermanName();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
