package corejava.serialization.clients;

import java.util.Set;

public class InvalidClientDetailsException extends Exception {

	private static final long serialVersionUID = -344772964702281139L;

	private String message;

	public InvalidClientDetailsException(Set<String> errors) {
		this.message = errors.toString();
	}

	@Override
	public String getMessage() {
		return message;
	}

}
