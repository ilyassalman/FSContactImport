package converter;

import domain.Organisation;

import java.util.List;

/**
 * Created by Lukas on 21.04.2015.
 */
public class OrganisationConverter extends AbstractConverter<Organisation> {

    List<Organisation> organisationList;
    public OrganisationConverter(List<Organisation> organisationList){
        super();
        this.organisationList = organisationList;
    }

    @Override
    public void addValue(String value) {
        //TODO
    }

    @Override
    public Organisation build() {
        //TODO
        return null;
    }
}
