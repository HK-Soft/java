package corejava.chpater8.annotations.validators;

import java.lang.annotation.Annotation;

public interface ValueValidator<T extends Annotation, V> {

	boolean isValid(T validator, V value);

}
