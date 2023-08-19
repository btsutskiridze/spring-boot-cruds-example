package com.bakari.restapi.constraint;

import com.bakari.restapi.validators.ValidDateFormatValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidDateFormatValidator.class)
public @interface ValidDateFormatConstraint {
    String message() default "Invalid date format (yyyy-MM-dd)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
