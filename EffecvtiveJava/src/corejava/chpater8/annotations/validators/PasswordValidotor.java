package corejava.chpater8.annotations.validators;

import corejava.chpater8.annotations.Password;

public class PasswordValidotor implements ValueValidator<Password, String> {

	@Override
	public boolean isValid(Password validator, String password) {
		System.out.println("Password called with properties : " + validator);
		System.out.println("Password called with vlaue " + password);
		return false;
	}

}
