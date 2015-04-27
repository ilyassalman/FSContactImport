import domain.ContactsEntity;
import domain.OrganisationsEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import repositories.ContactRepository;
import repositories.OrganisationRepository;

/**
 * Created by Dominik on 26.04.2015.
 */

@ContextConfiguration(locations = {"classpath:/applicationConfig.xml"})
@FixMethodOrder(value = MethodSorters.JVM)
public class ContactsTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private OrganisationRepository organisationRepository;

    ContactsEntity testContact;

    @Before
    public void setUp() throws Exception {
        testContact = new ContactsEntity();
        testContact.setAcademicDegreeAfter("dfadfasdf");
    }

    @Test
    public void testAddContact() {
        contactRepository.save(testContact);

        Assert.assertNotEquals(0, testContact.getId());
    }

    @Test
    public void testDeleteContact() {
        contactRepository.save(testContact);
        contactRepository.delete(testContact.getId());
    }

    @Test
    public void testSaveContactWithOrganisation() {
        OrganisationsEntity org = new OrganisationsEntity();
        org.setName("LAWL");
        organisationRepository.save(org);

        testContact.setOrganisationsByOrganisationsId(org);
        contactRepository.save(testContact);

        Assert.assertNotEquals(0, testContact.getId());
        Assert.assertNotEquals(0, org.getId());
    }

}
