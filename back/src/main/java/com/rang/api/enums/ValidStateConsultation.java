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
@Constraint(validatedBy = ValidStateConsultation.ValidSpecialtyValidator.class)
public @interface ValidStateConsultation {
    String message() default "Invalid state value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class ValidSpecialtyValidator implements ConstraintValidator<ValidStateConsultation, String> {
        private static final List<String> VALID_STATE = Arrays.asList("Aceita", "Cancelada", "Realizada", "Solicitada");

        @Override
        public void initialize(ValidStateConsultation constraintAnnotation) {
            // Initialize if needed
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return value != null && VALID_STATE.contains(value.trim());
        }
    }
}
