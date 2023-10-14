package pl.krzysztofskul.contactsapp.contact;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pl.krzysztofskul.contactsapp.entry.AddressEntry;

@SpringBootTest
class ContactDemoGeneratorTest {

	@Autowired
	private static ContactDemoGenerator contactDemoGenerator;
	
	@Autowired
	private ContactRepo contactRepo;
	
	private static List<Contact> testContactList = new ArrayList<Contact>();
	
	@BeforeClass
	static void testInitDataAndReturn() {
		testContactList = contactDemoGenerator.initDataAndReturn();
		assertTrue(testContactList != null);
	}
	
	@Test
	@Order(value = 1)
	void givenContactList_whenGetAddresEntry_shouldNotNull() {
		for (Contact contact : testContactList) {
			assertTrue(contact.getAddressesEntryList() != null & contact.getAddressesEntryList().size() > 0);
			assertTrue(contact.getEmailEntries() != null & contact.getEmailEntries().size() > 0);
			for (AddressEntry addressEntry: contact.getAddressesEntryList()) {
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
