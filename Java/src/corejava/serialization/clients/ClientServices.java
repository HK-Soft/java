package corejava.serialization.clients;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashSet;

import java.util.Set;


public class ClientServices {

	public static Client newPhysicalClient(ClientDTO clientDTO) throws InvalidClientDetailsException {

		PhysicalClient client = new PhysicalClient(clientDTO.title, clientDTO.firstname, clientDTO.lastname);
		client.setAddress(clientDTO.address);
		client.setEmail(clientDTO.email);
		client.setPhone(clientDTO.phone);
		Set<String> errors = check(client);
		if (!errors.isEmpty())
			throw new InvalidClientDetailsException(errors);

		return client;
	};

	public static Client newMoralClient(ClientDTO clientDTO) throws InvalidClientDetailsException {

		Contact contact = new Contact(clientDTO.title, clientDTO.firstname, clientDTO.lastname);
		contact.setEmail(clientDTO.email);
		contact.setPhone(clientDTO.phone);
		MoralClient client = new MoralClient(clientDTO.description, contact);
		client.setAddress(clientDTO.address);

		Set<String> errors = check(client);
		if (!errors.isEmpty())
			throw new InvalidClientDetailsException(errors);

		return client;
	};

	public static Set<String> check(Client client) {
		Set<String> errors = new HashSet<String>();

		if (client.getDescription() == null)
			errors.add("{client.description.null}");

		else if (client.getDescription().trim().isEmpty())
			errors.add("{client.description.empty}");

		if (client.getAddress() == null)
			errors.add("{client.address.null}");

		else if (client.getAddress().trim().isEmpty())
			errors.add("{client.address.empty}");

		if (client.getContact().getFirstname() == null)
			errors.add("{client.contact.firstname.null}");

		else if (client.getContact().getFirstname().trim().isEmpty())
			errors.add("{client.contact.firstname.empty}");

		if (client.getContact().getLastname() == null)
			errors.add("{client.contact.lastname.null}");

		else if (client.getContact().getLastname().trim().isEmpty())
			errors.add("{client.contact.lastname.empty}");

		String contactInfo = "";
		contactInfo = contactInfo.concat((client.getContact().getPhone() != null) ? client.getContact().getPhone() : "")
				.concat((client.getContact().getEmail() != null) ? client.getContact().getEmail() : "");

		if (contactInfo.trim().isEmpty())
			errors.add("{client.contact.contactInfo.notProvided}");

		return Collections.unmodifiableSet(errors);
	}

	public static void save(MoralClient client) {
		ObjectOutputStream output = null;
		try {
			output = new ObjectOutputStream(new FileOutputStream("persons.dat"));
			output.writeObject(client);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	public static Client loadMoralClient() {
		ObjectInputStream input;
		MoralClient client = null;
		try {
			input = new ObjectInputStream(new FileInputStream("persons.dat"));
			client = (MoralClient) input.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return client;
	}

}
