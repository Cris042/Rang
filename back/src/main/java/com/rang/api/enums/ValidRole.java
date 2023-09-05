package com.rang.api.enums;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidRole.ValidSpecialtyValidator.class)
public @interface ValidRole {
    String message() default "Invalid role value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class ValidSpecialtyValidator implements ConstraintValidator<ValidRole, String> {
        private static final List<String> VALID_SPECIALTIES = Arrays.asList("ROLE_ADM", "ROLE_PATIENT", "ROLE_DOC");

        @Override
        public void initialize(ValidRole constraintAnnotation) {
            // Initialize if needed
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return value != null && VALID_SPECIALTIES.contains(value.trim());
        }
    }
}
