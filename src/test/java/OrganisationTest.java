import domain.ContactsEntity;
import domain.OrganisationsEntity;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import repositories.OrganisationRepository;

/**
 * Created by Dominik on 26.04.2015.
 */

@ContextConfiguration(locations = {"classpath:/applicationConfig.xml"})
@FixMethodOrder(MethodSorters.JVM)
public class OrganisationTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    OrganisationRepository organisationRepository;

    OrganisationsEntity organisation = new OrganisationsEntity();

    @Test
    public void addOrganisation() {
        organisation.setName("trololol");

        organisationRepository.save(organisation);

        Assert.assertNotEquals(0, organisation.getId());
    }

    @Test
    public void removeOrganisation() {
        organisationRepository.save(organisation);

        organisationRepository.delete(organisation.getId());

        Assert.assertNull(organisationRepository.findOne(organisation.getId()));
    }

    @Test
    public void testSaveOrganisationWithContact() {
        ContactsEntity contact = new ContactsEntity();
        contact.setAcademicDegreeAfter("lolololol");

        organisation.getContactsesById().add(contact);

        organisationRepository.save(organisation);

        Assert.assertNotEquals(0, contact.getId());
        Assert.assertNotEquals(0, organisation.getId());


    }

}
