package corejava.chpater8.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import corejava.chpater8.annotations.validators.PasswordValidotor;

@Retention(RUNTIME)
@Target({ FIELD, PARAMETER })
@ValidotorClass(validator = PasswordValidotor.class)
public @interface Password {

	int minSize() default 8;

	int maxSize() default 24;

	boolean mustHaveUppercase() default false;

	boolean mustHaveNubmers() default false;

	boolean mustHaveSpecialChareter() default false;

}
