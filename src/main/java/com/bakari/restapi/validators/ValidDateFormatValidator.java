package com.bakari.restapi.validators;


import com.bakari.restapi.constraint.ValidDateFormatConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidDateFormatValidator implements ConstraintValidator<ValidDateFormatConstraint, String> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void initialize(ValidDateFormatConstraint constraintAnnotation) {
        // No initialization needed
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        try {
            // Attempt to parse the date using the specified format
            LocalDate dob = LocalDate.parse(value, DATE_FORMATTER);

            if (dob.isAfter(LocalDate.now())) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Date must not be in the future")
                        .addConstraintViolation();

                return false;
            }

            return true;
        } catch (DateTimeParseException e) {
            // The date could not be parsed, so it is not valid
            return false;
        }
    }
}
