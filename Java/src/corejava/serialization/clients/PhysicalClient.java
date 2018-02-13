package corejava.serialization.clients;

public class PhysicalClient implements Client {

	private String address;

	private final Contact contact;

	public PhysicalClient(String title, String firstname, String lastname) {
		this.contact = new Contact(title, firstname, lastname);
	}

	public String getFirstname() {
		return contact.getFirstname();
	}

	public void setFirstname(String firstname) {
		this.contact.setFirstname(firstname);
	}

	public String getLastname() {
		return contact.getLastname();
	}

	public void setLastname(String lastname) {
		this.contact.setLastname(lastname);
	}

	public String getPhone() {
		return this.contact.getPhone();
	}

	public void setPhone(String phone) {
		this.contact.setPhone(phone);
	}

	public String getEmail() {
		return this.getEmail();
	}

	public void setEmail(String email) {
		this.contact.setEmail(email);
	}

	public String getTitle() {
		return this.contact.getTitle();
	}

	public void setTitle(String title) {
		this.contact.setTitle(title);
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getDescription() {
		return contact.getFirstname().toUpperCase() + " " + contact.getLastname();
	}

	@Override
	public Contact getContact() {
		return contact;
	}

	@Override
	public String getAddress() {
		return this.address;
	}
}
