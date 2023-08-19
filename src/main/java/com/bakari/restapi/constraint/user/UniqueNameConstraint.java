package com.bakari.restapi.constraint.user;


import com.bakari.restapi.validators.user.UniqueNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueNameConstraint {
    String message() default "Name should be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
