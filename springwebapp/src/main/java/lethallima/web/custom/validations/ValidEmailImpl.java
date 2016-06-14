package lethallima.web.custom.validations;

import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by LethalLima on 6/13/16.
 */
public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String> {
    public void initialize(ValidEmail validEmail) {
    }

    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return EmailValidator.getInstance(false).isValid(email);
    }
}
