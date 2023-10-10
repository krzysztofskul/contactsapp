package pl.krzysztofskul.contactsapp.contact;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pl.krzysztofskul.contactsapp.subject.Subject;
import pl.krzysztofskul.contactsapp.subject.SubjectDemoGenerator;

@SpringBootTest
class ContactDemoGeneratorTest {

	@Autowired
	private ContactDemoGenerator contactDemoGenerator;
	
	@Test
	void testInitDataAndReturn() {
		List<Contact> contactList = contactDemoGenerator.initDataAndReturn();
		assertTrue(contactList != null);
	}

}
