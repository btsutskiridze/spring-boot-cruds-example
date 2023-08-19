package com.bakari.restapi.constraint.user;

import com.bakari.restapi.validators.user.UniqueEmailValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmailConstraint {
    String message() default "Email should be unique";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
