package corejava.chapter4.item13_16_19_20_22;

public class Client {

	private String firstname;

	private String lastname;

	public Client(String firstname, String lastname) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
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

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Client) && (this.firstname.equalsIgnoreCase(((Client) obj).firstname))
				&& (this.lastname.equalsIgnoreCase(((Client) obj).lastname));
	}

	@Override
	public int hashCode() {
		int result = 17;
		for (char ch : firstname.toCharArray())
			result += 24 * result + (int) ch;
		for (char ch : lastname.toCharArray())
			result = 24 * result + (int) ch;
		return result;

	}

	@Override
	public String toString() {
		return firstname.toUpperCase() + " " + lastname.toLowerCase();
	}

}
