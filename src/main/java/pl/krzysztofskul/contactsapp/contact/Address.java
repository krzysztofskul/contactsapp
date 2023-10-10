package pl.krzysztofskul.contactsapp.contact;

public class Address {
	
	private String country;
	
	private String zipCode;
	
	private String city;
	
	private String streetName;
	
	private String streetNo;
	
	private String flatNo;
	
	public Address() {
		//Auto-generated constructor stub
	}
	
	/**
	 * @param country
	 * @param zipCode
	 * @param city
	 * @param streetName
	 * @param streetNo
	 * @param flatNo
	 */
	public Address(String country, String zipCode, String city, String streetName, String streetNo, String flatNo) {
		this.country = country;
		this.zipCode = zipCode;
		this.city = city;
		this.streetName = streetName;
		this.streetNo = streetNo;
		this.flatNo = flatNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	
	
	
}
