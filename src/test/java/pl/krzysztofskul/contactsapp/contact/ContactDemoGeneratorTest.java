package pl.krzysztofskul.contactsapp.contact;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pl.krzysztofskul.contactsapp.entry.AddressEntry;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class ContactDemoGeneratorTest {

	@Autowired
	private ContactDemoGenerator contactDemoGenerator;
	
	@Autowired
	private ContactRepo contactRepo;
	
	public List<Contact> testContactList = new ArrayList<Contact>();
	
	@BeforeAll
	void testInitDataAndReturn() {
		testContactList = contactDemoGenerator.initDataAndReturn();
		assertTrue(testContactList != null & testContactList.size() > 0);
	}
	
	@Test
	@Order(value = 1)
	void givenContactList_whenGetAddressEntry_shouldNotNull() {
		for (Contact contact : testContactList) {
			assertTrue(contact.getAddressEntryList() != null & contact.getAddressEntryList().size() > 0);
			assertTrue(contact.getEmailEntries() != null & contact.getEmailEntries().size() > 0);
			for (AddressEntry addressEntry: contact.getAddressEntryList()) {
				assertTrue(addressEntry.getAddress() != null);
				assertTrue(addressEntry.getAddress().getCountry() != null);
			}
			assertTrue(contact.getPhoneNumberEntries() != null & contact.getPhoneNumberEntries().size() > 0);
		}

	}

	@Test
	@Order(value = 2)
	void givenContactList_whenSaveToDb_shouldIdNotNull() {
		for (Contact contact : testContactList) {
			Contact contactSaved = contactRepo.save(contact);
			assertTrue(contactSaved.getId() != null & contactSaved.getId() != 0);
		}
	}
	
}
