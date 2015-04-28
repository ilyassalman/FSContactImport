package domain.ConverterComparable;

import domain.PostleitzahlEntity;

/**
 * Created by Lukas on 28.04.2015.
 */
public class PLZComparable extends ConverterComparable<PostleitzahlEntity> {
    public PLZComparable(PostleitzahlEntity entityToCompare) {
        super(entityToCompare);
    }

    @Override
    public String getTextToCompare() {
        return String.valueOf(entityToCompare.getPlz());
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
