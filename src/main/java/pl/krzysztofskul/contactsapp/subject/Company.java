package pl.krzysztofskul.contactsapp.subject;

import pl.krzysztofskul.contactsapp.contact.Address;

public class Company extends Subject {

	private String name;

	private Address address;

	/**
	 * 
	 */
	public Company() {
		// TODO Auto-generated constructor stub
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
