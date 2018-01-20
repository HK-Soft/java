package corejava.chpater8.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import corejava.chpater8.annotations.validators.ValueValidator;

@Retention(RUNTIME)
@Target({ ElementType.TYPE })
public @interface ValidotorClass {

	@SuppressWarnings("rawtypes")
	Class<? extends ValueValidator> validator();

	
}
