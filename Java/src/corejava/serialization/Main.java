package corejava.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Person person = new Person("firstname", "lastname", "username", "a password encoding");

		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("persons.dat"));
		output.writeObject(new PersonDTO(person.getFirstname(), person.getLastname(), person.getUsername()));

		ObjectInputStream input = new ObjectInputStream(new FileInputStream("persons.dat"));
		PersonDTO personDTO = (PersonDTO) input.readObject();
		System.out.println(personDTO);
	}
}
