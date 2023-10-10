package pl.krzysztofskul.contactsapp.subject;

public class Person extends Subject {

	private String nickname;
	
	private String nameFirst;
	
	private String nameLast;
	
	private String gender;

	/**
	 * 
	 */
	public Person() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nickname
	 * @param nameFirst
	 * @param nameLast
	 * @param gender
	 */
	public Person(String nickname, String nameFirst, String nameLast, String gender) {
		this.nickname = nickname;
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.gender = gender;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the nameFirst
	 */
	public String getNameFirst() {
		return nameFirst;
	}

	/**
	 * @param nameFirst the nameFirst to set
	 */
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	/**
	 * @return the nameLast
	 */
	public String getNameLast() {
		return nameLast;
	}

	/**
	 * @param nameLast the nameLast to set
	 */
	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
