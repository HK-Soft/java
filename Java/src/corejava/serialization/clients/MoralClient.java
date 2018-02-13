package corejava.serialization.clients;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Set;

public class MoralClient implements Client, Serializable {

	private static final long serialVersionUID = 189675974640512912L;

	private transient String companyName;

	private transient String address;

	private transient Contact contact;

	public MoralClient(String companyName, Contact contact) {
		this.companyName = companyName;
		this.contact = contact;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return getDescription();
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public Contact getContact() {
		return this.contact;
	}

	@Override
	public String getDescription() {
		return companyName;
	}

	@Override
	public String getAddress() {
		return this.address;
	}

	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();
		s.writeObject(getDescription());
		s.writeObject(getAddress());
		s.writeObject(contact.getTitle());
		s.writeObject(contact.getFirstname());
		s.writeObject(contact.getLastname());
		s.writeObject(contact.getPhone());
		s.writeObject(contact.getEmail());
	}

	private void readObject(ObjectInputStream s)
			throws IOException, ClassNotFoundException, InvalidClientDetailsException {
		s.defaultReadObject();
		setCompanyName((String) s.readObject());
		setAddress((String) s.readObject());
		Contact contact = new Contact((String) s.readObject(), (String) s.readObject(), (String) s.readObject());
		contact.setPhone((String) s.readObject());
		contact.setEmail((String) s.readObject());
		setContact(contact);
		// Validate the client
		Set<String> errors = ClientServices.check(this);
		if (!errors.isEmpty())
			throw new InvalidClientDetailsException(errors);

	}

	@Override
	public String toString() {
		return "Moral Client { " + 
				"\n\t Company Name	: " + getDescription() + 
				"\n\t Address	: " 	+ getAddress() + 
				getContact().toString() + 
				"\n }";
	}
}
