package pl.krzysztofskul.contactsapp.entry;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pl.krzysztofskul.contactsapp.contact.Contact;

@Entity
@Table(name = "contactsapp_emailentry")
public class EmailEntry<T> extends Entry<String> {
	
	@ManyToOne
	@JsonIgnore
	private Contact contact;
	
	private String data;
	
	/**
	 * 
	 */
	public EmailEntry() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param data
	 */
	public EmailEntry(String name, String data) {
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
