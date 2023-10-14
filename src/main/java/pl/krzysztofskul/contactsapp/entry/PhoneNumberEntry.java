package pl.krzysztofskul.contactsapp.entry;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import pl.krzysztofskul.contactsapp.contact.Contact;

@Entity
public class PhoneNumberEntry<T> extends Entry<String> {
	
	@ManyToOne
	private Contact contact;
	
	private String data;
	
	/**
	 * 
	 */
	public PhoneNumberEntry() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param data
	 */
	public PhoneNumberEntry(String name, String data) {
		super(name, data);
		this.data = data;
	}

	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	
	
}
