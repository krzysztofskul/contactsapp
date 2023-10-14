package pl.krzysztofskul.contactsapp.entry;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import pl.krzysztofskul.contactsapp.contact.Address;
import pl.krzysztofskul.contactsapp.contact.Contact;

@Entity
public class AddressEntry extends Entry<Address> {
	
	@ManyToOne
	private Contact contact;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
	/**
	 * 
	 */
	public AddressEntry() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param data
	 */
	public AddressEntry(String name, Address data) {
		super(name, data);
		this.address = data;
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
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}
