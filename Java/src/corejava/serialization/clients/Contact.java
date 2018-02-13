package corejava.serialization.clients;

public class Contact {

	private String title;

	private String firstname;

	private String lastname;

	private String phone;

	private String email;

	public Contact(String title, String firstname, String lastname) {
		this.title = title;
		this.firstname = firstname;
		this.lastname = lastname;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		
		return 	"\n\t Contact { " + 
				"\n\t\t Title     : " 	+ getTitle()	 +	
				"\n\t\t Firstname : " 	+ getFirstname() + 
				"\n\t\t Lastname  : " 	+ getLastname()	 +
				"\n\t\t Phone     : " 	+ getPhone()	 +
				"\n\t\t Email     : " 	+ getEmail() 	 + 
				"\n\t}";
	}
}
