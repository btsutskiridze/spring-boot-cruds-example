package com.bakari.restapi.validators.user;

import com.bakari.restapi.constraint.user.UniqueNameConstraint;
import com.bakari.restapi.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;


public class UniqueNameValidator implements ConstraintValidator<UniqueNameConstraint, String> {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void initialize(UniqueNameConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return name == null || userRepository.findUserByName(name).isEmpty();
    }
}
