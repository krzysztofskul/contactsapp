package pl.krzysztofskul.contactsapp.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.contactsapp.entry.AddressEntry;
import pl.krzysztofskul.contactsapp.entry.EmailEntry;
import pl.krzysztofskul.contactsapp.entry.PhoneNumberEntry;
import pl.krzysztofskul.contactsapp.subject.Subject;
import pl.krzysztofskul.contactsapp.subject.SubjectDemoGenerator;
import pl.krzysztofskul.sensit.smnsh.init.InitDataGenerator;

@Service
public class ContactDemoGenerator implements InitDataGenerator<Contact> {

	private final LoremIpsum loremIpsum = LoremIpsum.getInstance();
	private final Random random = new Random();
	
	private SubjectDemoGenerator<Subject> subjectDemoGenerator;
		
	

	/**
	 * @param subjectDemoGenerator
	 */
	public ContactDemoGenerator(SubjectDemoGenerator subjectDemoGenerator) {
		this.subjectDemoGenerator = subjectDemoGenerator;
	}

	@Override
	public List<Contact> initDataAndReturn() {
		List<Contact> demoContactList = new ArrayList<Contact>();
		for (Subject subject : subjectDemoGenerator.initDataAndReturn()) {
			demoContactList.add(getDemoContact(subject));
		}
	
		
		
		return demoContactList;
	}

	private Contact getDemoContact(Subject subject) {
		Contact contact = new Contact();
		contact.setEmailEntries(getDemoEmails());
		contact.setPhoneNumberEntries(getDemoPhoneNumbers());
		contact.setAddressesEntryList(getDemoAddressItems());		
		contact.setSubject(subject);
		return contact;
	}

	private List<AddressEntry> getDemoAddressItems() {
		List<AddressEntry> demoAddressItemList = new ArrayList<AddressEntry>();
		demoAddressItemList.add(new AddressEntry("Main address", getDemoAddress()));
		demoAddressItemList.add(new AddressEntry("Second address", getDemoAddress()));
		return demoAddressItemList;

	}
	
	private Address getDemoAddress() {
		return new Address(loremIpsum.getCountry(), loremIpsum.getZipCode(), loremIpsum.getCity(), loremIpsum.getName(), String.valueOf(random.nextInt(99)+1), String.valueOf(random.nextInt(99)+1));
	}

	private List<EmailEntry> getDemoEmails() {
		List<EmailEntry> demoEmailList = new ArrayList<EmailEntry>();
		demoEmailList.add(new EmailEntry<String>("Private email", "private@example.com"));
		demoEmailList.add(new EmailEntry<String>("Business email", "office@example.com"));
		return demoEmailList;
	}
	
	private List<PhoneNumberEntry> getDemoPhoneNumbers() {
		List<PhoneNumberEntry> demoPhoneNumberList = new ArrayList<PhoneNumberEntry>();
		demoPhoneNumberList.add(new PhoneNumberEntry<String>("Private phone no.", loremIpsum.getPhone()));
		demoPhoneNumberList.add(new PhoneNumberEntry<String>("Private mobile no.", loremIpsum.getPhone()));
		demoPhoneNumberList.add(new PhoneNumberEntry<String>("Business phone no.", loremIpsum.getPhone()));
		return demoPhoneNumberList;
	}

}
