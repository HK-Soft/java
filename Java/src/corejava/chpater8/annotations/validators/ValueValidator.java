package corejava.chpater8.annotations.validators;

import java.lang.annotation.Annotation;

//The validator contract
public interface ValueValidator<T extends Annotation, V> {

	boolean isValid(T validator, V value);

}
