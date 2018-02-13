package corejava.chpater8.annotations.validators;

import corejava.chpater8.annotations.IsUnique;

//Implementing the isUnique validation constraintes
public class IsUniqueValidator implements ValueValidator<IsUnique, String> {

	@Override
	public boolean isValid(IsUnique validator, String value) {
		System.out.println("Unique called with properties : " + validator);
		System.out.println("Unique called with value " + value);
		return false;
	}

}
