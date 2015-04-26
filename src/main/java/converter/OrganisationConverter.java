package converter;

import domain.Organisation;
import logic.StringTrimmer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lukas on 21.04.2015.
 */
public class OrganisationConverter extends AbstractConverter<Organisation> {

    List<Organisation> organisationList;
    Organisation organisation;

    public OrganisationConverter(List<Organisation> all) {
        super();
        this.organisationList = all;
    }


    @Override
    public AbstractConverter<Organisation> addValue(String value) {
        if (StringTrimmer.trim(value).isEmpty()) {
            organisation = null;
            return this;
        }
        if (value.toUpperCase().contains("FAIR") && value.toUpperCase().contains("SENSIBEL")) {
            value = "Fair und Sensibel";
        }

        Organisation org = new Organisation(StringTrimmer.trim(value));
        if (organisationList.contains(org)) {
            organisation = organisationList.get(organisationList.indexOf(org));
        } else {
            organisation = org;
            organisationList.add(org);
        }
        return this;
    }

    @Override
    public Organisation build() {
        return organisation;
    }

    public List<Organisation> getOrganisationList() {
        return organisationList;
    }
}
