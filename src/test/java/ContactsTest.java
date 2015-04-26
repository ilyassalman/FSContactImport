import domain.Contact;
import domain.Organisation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import repositories.ContactRepository;

/**
 * Created by Dominik on 26.04.2015.
 */

@ContextConfiguration(locations = {"classpath:/applicationConfig.xml"})
@FixMethodOrder(value = MethodSorters.JVM)
public class ContactsTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private ContactRepository contactRepository;

    Contact testContact;

    @Before
    public void setUp() throws Exception {
        testContact = new Contact();
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
        Organisation org = new Organisation();

        testContact.setOrganisation(org);
        contactRepository.save(testContact);

        Assert.assertNotEquals(0, testContact.getId());
        Assert.assertNotEquals(0, org.getId());
    }

}
