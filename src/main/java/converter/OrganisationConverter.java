package converter;

import domain.OrganisationsEntity;
import logic.StringTrimmer;

import java.util.List;

/**
 * Created by Lukas on 21.04.2015.
 */
public class OrganisationConverter extends AbstractConverter<OrganisationsEntity> {

    List<OrganisationsEntity> organisationList;
    OrganisationsEntity organisation;

    public OrganisationConverter(List<OrganisationsEntity> all) {
        super();
        this.organisationList = all;
    }


    @Override
    public AbstractConverter<OrganisationsEntity> addValue(String value) {
        if (StringTrimmer.trim(value).isEmpty()) {
            organisation = null;
            return this;
        }
        if (value.toUpperCase().contains("FAIR") && value.toUpperCase().contains("SENSIBEL")) {
            value = "Fair und Sensibel";
        }

        OrganisationsEntity org = new OrganisationsEntity();
        org.setName(StringTrimmer.trim(value));
        if (organisationList.contains(org)) {
            organisation = organisationList.get(organisationList.indexOf(org));
        } else {
            organisation = org;
            organisationList.add(org);
        }
        return this;
    }

    @Override
    public OrganisationsEntity build() {
        return organisation;
    }

    public List<OrganisationsEntity> getOrganisationList() {
        return organisationList;
    }
}
