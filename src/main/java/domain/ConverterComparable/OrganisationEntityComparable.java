package domain.ConverterComparable;

import domain.OrganisationsEntity;

/**
 * Created by Lukas on 27.04.2015.
 */
public class OrganisationEntityComparable extends ConverterComparable<OrganisationsEntity> {
    public OrganisationEntityComparable(OrganisationsEntity entityToCompare) {
        super(entityToCompare);
    }

    @Override
    public String getTextToCompare() {
        return entityToCompare.getName();
    }
}
