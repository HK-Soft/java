package corejava.serialization;

public class Person {

	private String firstname;

	private String lastname;

	private String password;

	private String username;

	public Person(String firstname, String lastname, String username, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
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

	public boolean isPassowrdValid(String password) {
		return (password.equals(this.password));
	}

	public void setPassword(String newPassword, String oldPassword) {
		if (!isPassowrdValid(oldPassword))
			return;
		this.password = newPassword;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person))
			return false;
		return username.equalsIgnoreCase(((Person) obj).username);
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
}
