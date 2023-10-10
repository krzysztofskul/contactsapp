package pl.krzysztofskul.contactsapp.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.contactsapp.item.AddressItem;
import pl.krzysztofskul.contactsapp.item.Email;
import pl.krzysztofskul.contactsapp.item.PhoneNumber;
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
		contact.setEmails(getDemoEmails());
		contact.setPhoneNumbers(getDemoPhoneNumbers());
		contact.setAddresses(getDemoAddressItems());		
		contact.setSubject(subject);
		return contact;
	}

	private List<AddressItem> getDemoAddressItems() {
		List<AddressItem> demoAddressItemList = new ArrayList<AddressItem>();
		demoAddressItemList.add(new AddressItem<Address>("Main address", getDemoAddress()));
		demoAddressItemList.add(new AddressItem<Address>("Second address", getDemoAddress()));
		return demoAddressItemList;

	}
	
	private Address getDemoAddress() {
		return new Address(loremIpsum.getCountry(), loremIpsum.getZipCode(), loremIpsum.getCity(), loremIpsum.getName(), String.valueOf(random.nextInt(99)+1), String.valueOf(random.nextInt(99)+1));
	}

	private List<Email> getDemoEmails() {
		List<Email> demoEmailList = new ArrayList<Email>();
		demoEmailList.add(new Email<String>("Private email", "private@example.com"));
		demoEmailList.add(new Email<String>("Business email", "office@example.com"));
		return demoEmailList;
	}
	
	private List<PhoneNumber> getDemoPhoneNumbers() {
		List<PhoneNumber> demoPhoneNumberList = new ArrayList<PhoneNumber>();
		demoPhoneNumberList.add(new PhoneNumber<String>("Private phone no.", loremIpsum.getPhone()));
		demoPhoneNumberList.add(new PhoneNumber<String>("Private mobile no.", loremIpsum.getPhone()));
		demoPhoneNumberList.add(new PhoneNumber<String>("Business phone no.", loremIpsum.getPhone()));
		return demoPhoneNumberList;
	}

}
