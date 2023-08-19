package com.bakari.restapi.dto;


import com.bakari.restapi.constraint.ValidDateFormatConstraint;
import com.bakari.restapi.constraint.user.UniqueEmailConstraint;
import com.bakari.restapi.constraint.user.UniqueNameConstraint;
import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.Default;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserCreateDto {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters")
    @UniqueNameConstraint(message = "Name already exists")
    private String name;


    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @UniqueEmailConstraint(message = "Email already exists")
    private String email;

    @Getter(AccessLevel.NONE)
    @NotNull(message = "Date of birth is mandatory")
    @ValidDateFormatConstraint()
    private String dob;

    public LocalDate getDob() {
        return LocalDate.parse(dob);
    }
}