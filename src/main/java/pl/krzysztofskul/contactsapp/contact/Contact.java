package pl.krzysztofskul.contactsapp.contact;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import pl.krzysztofskul.contactsapp.entry.AddressEntry;
import pl.krzysztofskul.contactsapp.entry.EmailEntry;
import pl.krzysztofskul.contactsapp.entry.PhoneNumberEntry;
import pl.krzysztofskul.contactsapp.subject.Subject;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private Subject subject;
	
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PhoneNumberEntry> phoneNumberEntries = new ArrayList();
	
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<EmailEntry> emailEntries = new ArrayList();
	
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<AddressEntry> addressEntryList = new ArrayList<AddressEntry>();

	/**
	 * 
	 */
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param subject
	 * @param phoneNumberEntries
	 * @param emailEntries
	 * @param addressesEntryList
	 */
	public Contact(Subject subject, List<PhoneNumberEntry> phoneNumberEntries, List<EmailEntry> emailEntries, List<AddressEntry> addressEntryList) {
		this.subject = subject;
		this.phoneNumberEntries = phoneNumberEntries;
		this.emailEntries = emailEntries;
		this.addressEntryList = addressEntryList;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * @return the phoneNumberEntries
	 */
	public List<PhoneNumberEntry> getPhoneNumberEntries() {
		return phoneNumberEntries;
	}

	/**
	 * @param phoneNumberEntries the phoneNumberEntries to set
	 */
	public void setPhoneNumberEntries(List<PhoneNumberEntry> phoneNumberEntries) {
		this.phoneNumberEntries = phoneNumberEntries;
		for (PhoneNumberEntry phoneNumberEntry : phoneNumberEntries) {
			phoneNumberEntry.setContact(this);
		}
	}

	/**
	 * @return the emailEntries
	 */
	public List<EmailEntry> getEmailEntries() {
		return emailEntries;
	}

	/**
	 * @param emailEntries the emailEntries to set
	 */
	public void setEmailEntries(List<EmailEntry> emailEntries) {
		this.emailEntries = emailEntries;
		for (EmailEntry emailEntry : emailEntries) {
			emailEntry.setContact(this);
		}
	}

	/**
	 * @return the addressesEntryList
	 */
	public List<AddressEntry> getAddressEntryList() {
		return addressEntryList;
	}

	/**
	 * @param addressesEntryList the addressesEntryList to set
	 */
	public void setAddressEntryList(List<AddressEntry> addressEntryList) {
		this.addressEntryList = addressEntryList;
		for (AddressEntry addressEntry : addressEntryList) {
			addressEntry.setContact(this);
		}
	}



	
}
