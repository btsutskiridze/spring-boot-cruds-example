package com.bakari.restapi.validators.user;

import com.bakari.restapi.constraint.user.UniqueEmailConstraint;
import com.bakari.restapi.model.User;
import com.bakari.restapi.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmailConstraint, String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueEmailConstraint uniqueEmailConstraint) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return email == null || userRepository.findUserByEmail(email).isEmpty();
    }
}
