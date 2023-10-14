package pl.krzysztofskul.contactsapp.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

//import javax.persistence.OneToMany;

import pl.krzysztofskul.contactsapp.item.AddressItem;
import pl.krzysztofskul.contactsapp.item.Email;
import pl.krzysztofskul.contactsapp.item.PhoneNumber;
import pl.krzysztofskul.contactsapp.subject.Subject;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private Subject subject;
	
	@OneToMany(mappedBy = "contact")
	private List<PhoneNumber> phoneNumbers = new ArrayList();
	
	@OneToMany(mappedBy = "contact")
	private List<Email> emails = new ArrayList();
	
	@OneToMany(mappedBy = "contact")
	private List<AddressItem> addresses = new ArrayList();

	/**
	 * 
	 */
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param subject
	 * @param phoneNumbers
	 * @param emails
	 * @param addresses
	 */
	public Contact(Subject subject, List<PhoneNumber> phoneNumbers, List<Email> emails, List<AddressItem> addresses) {
		this.subject = subject;
		this.phoneNumbers = phoneNumbers;
		this.emails = emails;
		this.addresses = addresses;
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
	 * @return the phoneNumbers
	 */
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	/**
	 * @param phoneNumbers the phoneNumbers to set
	 */
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	/**
	 * @return the emails
	 */
	public List<Email> getEmails() {
		return emails;
	}

	/**
	 * @param emails the emails to set
	 */
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	/**
	 * @return the addresses
	 */
	public List<AddressItem> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<AddressItem> addresses) {
		this.addresses = addresses;
	}
	
}