package pl.krzysztofskul.contactsapp.contact;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContactServiceTest extends ContactDemoGeneratorTest {

	@Autowired
	private ContactService contactService;
	@Autowired
	private ContactDemoGenerator contactDemoGenerator;
	
	private List<Contact> contactsLoaded = new ArrayList<Contact>();
	
	@Test
	@Order(1)
	void givenContact_whenSave_sholudReturnIdNotNull() {
		for (Contact contact : contactDemoGenerator.initDataAndReturn()) {
			assertNotNull(contactService.save(contact));
		}
	}
	
	@Test
	@Order(2)
	void givenContactsInDb_whenLoadAll_shouldNotNull() {
		contactsLoaded = contactService.loadAll();
		assertNotEquals(0, contactsLoaded.size());
	}
	
	@Test
	@Order(3)
	void givenContactList_whenLoadById_shouldLoadAllData() {
		contactsLoaded = contactService.loadAll();
		for (Iterator iterator = contactsLoaded.iterator(); iterator.hasNext();) {
			Contact contact = (Contact) iterator.next();
			Long id = contact.getId();
			assertTrue(contactService.loadById(id).getAddressEntryList().size() > 0);
		}
		
	}

}
