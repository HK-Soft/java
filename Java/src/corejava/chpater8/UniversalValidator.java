package corejava.chpater8;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import corejava.chpater8.annotations.IsUnique;
import corejava.chpater8.annotations.Password;
import corejava.chpater8.annotations.ValidotorClass;
import corejava.chpater8.annotations.validators.ValueValidator;

/**
 * 
 * 
 *
 * the Goal is to create a unified and consistence way to validate data in
 * object.
 * 
 * 
 */
public class UniversalValidator {

	@SuppressWarnings("rawtypes")
	private static Class[] supportedValidator = { IsUnique.class, Password.class };

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {

		RegistrationDTO registration = new RegistrationDTO();
		registration.setPassword("password");
		registration.setUsername("username");

		ProductDTO product = new ProductDTO();
		product.code = "FXZ55zA";

		System.out.println("Validating Registraion form");
		validate(registration);
		System.out.println();
		System.out.println("Validating new product form");
		validate(product);
	}

	//
	@SuppressWarnings("unchecked")
	public static void validate(Object obj) throws InstantiationException, IllegalAccessException {
		for (Field field : obj.getClass().getDeclaredFields())
			for (int i = 0; i < supportedValidator.length; i++)
				if (field.isAnnotationPresent(supportedValidator[i])) {
					// Retrieve the class that implements ValueValidotor
					ValidotorClass[] validotorClass = field.getAnnotation(supportedValidator[i]).annotationType()
							.getAnnotationsByType(ValidotorClass.class);

					for (int j = 0; j < validotorClass.length; j++) {
						ValueValidator<Annotation, Object> valueValidator = validotorClass[j].validator().newInstance();
						Annotation validationType = field.getAnnotation(supportedValidator[i]);
						Object value = field.get(obj);
						valueValidator.isValid(validationType, value);
					}
				}
	}

}
