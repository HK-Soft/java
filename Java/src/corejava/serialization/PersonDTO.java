package corejava.serialization;

import java.io.Serializable;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 7152024737951908361L;

	private String firstname;

	private String lastname;

	private String username;

	public PersonDTO() {
	}

	public PersonDTO(String firstname, String lastname, String username) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Firstname : " + firstname + " Lastname : " + lastname + " username " + username;
	}

}
