package pl.krzysztofskul.contactsapp.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import pl.krzysztofskul.contactsapp.contact.Contact;

@Entity
public class PhoneNumber<T> extends Item<String> {
	
	@ManyToOne
	private Contact contact;
	
	private String data;
	
	/**
	 * 
	 */
	public PhoneNumber() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param data
	 */
	public PhoneNumber(String name, String data) {
		super(name, data);
		// TODO Auto-generated constructor stub
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
