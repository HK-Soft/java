package corejava.chpater8.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import corejava.chpater8.annotations.validators.IsUniqueValidator;

/**
 * 
 * test if the value is unique in a table
 *
 */
@Retention(RUNTIME)
@Target({ FIELD, PARAMETER })
@ValidotorClass(validator = IsUniqueValidator.class)
public @interface IsUnique {

	String tableName();

	String columnName();

}
