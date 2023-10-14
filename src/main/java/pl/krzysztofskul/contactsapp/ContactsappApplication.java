package pl.krzysztofskul.contactsapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import pl.krzysztofskul.contactsapp.contact.Contact;
import pl.krzysztofskul.contactsapp.contact.ContactDemoGenerator;
import pl.krzysztofskul.contactsapp.contact.ContactRepo;

@SpringBootApplication
@Service
public class ContactsappApplication {

	private static ContactDemoGenerator contactDemoGenerator;
	private static ContactRepo contactRepo;
	
	@Autowired
	public ContactsappApplication(ContactDemoGenerator contactDemoGenerator, ContactRepo contactRepo) {
		this.contactDemoGenerator = contactDemoGenerator;
		this.contactRepo = contactRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(ContactsappApplication.class, args);
		initTestData();
	}

	private static void initTestData() {
		System.out.println("init test data..");
		
		List<Contact> testContactList = contactDemoGenerator.initDataAndReturn();
		for (Contact contact : testContactList) {
			contactRepo.save(contact);
		}
	}
	
}
