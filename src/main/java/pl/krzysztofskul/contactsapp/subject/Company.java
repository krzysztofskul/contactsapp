package pl.krzysztofskul.contactsapp.subject;

import javax.persistence.Entity;
import javax.persistence.Transient;

import pl.krzysztofskul.contactsapp.contact.Address;

@Entity
public class Company extends Subject {

	private String name;

	@Transient
	private Address address;

	public Company() {
	}
	
	/**
	 * @param name
	 */
	public Company(String name) {
		this.name = name;
	}



	/**
	 * @param name
	 * @param address
	 */
	public Company(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
