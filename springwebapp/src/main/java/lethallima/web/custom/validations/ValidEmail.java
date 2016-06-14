package lethallima.web.custom.validations;

/**
 * Created by LethalLima on 6/13/16.
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidEmailImpl.class)
public @interface ValidEmail {
    String message() default "This appears to be an invalid email.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
