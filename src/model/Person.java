package model;

/**
 * @author Mohamed Amine NASSEH
 * 
 *         Bean Person
 */
public class Person {

	private long idPerson;
	private String name;
	private String firstName;
	private String birthday;
	private String mail;
	private String webSite;
	private String password;
	private long groupId;
	
	
	
	public Person() {
		super();
	}

	public Person(String name, String firstName, String birthday, String mail, String webSite,
			String password, long groupId) {
		super();
		//this.idPerson = idPerson;
		this.name = name;
		this.firstName = firstName;
		this.birthday = birthday;
		this.mail = mail;
		this.webSite = webSite;
		this.password = password;
		this.groupId = groupId;
	}

	/**
	 * @return the idPerson
	 */
	public long getIdPerson() {
		return idPerson;
	}

	/**
	 * @param idPerson
	 *            the idPerson to set
	 */
	public void setIdPerson(long idPerson) {
		this.idPerson = idPerson;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the webSite
	 */
	public String getWebSite() {
		return webSite;
	}

	/**
	 * @param webSite
	 *            the webSite to set
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the groupId
	 */
	public long getGroupId() {
		return groupId;
	}

	/**
	 * @param groupID
	 *            the groupId to set
	 */
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

}