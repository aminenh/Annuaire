package model;

/**
 * @author Mohamed Amine NASSEH
 * 
 *         Bean Group
 */
public class Group {

	private long idGroup;
	private String name;
	private int nbMembers;

	public Group() {
		super();
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the idGroup
	 */
	public long getIdGroup() {
		return idGroup;
	}

	/**
	 * @param idGroup
	 *            the idGroup to set
	 */
	public void setIdGroup(long idGroup) {
		this.idGroup = idGroup;
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
	 * @return the nbMembers
	 */
	public int getNbMembers() {
		return nbMembers;
	}

	/**
	 * @param nbMembers
	 *            the nbMembers to set
	 */
	public void setNbMembers(int nbMembers) {
		this.nbMembers = nbMembers;
	}

}