package com.bakari.restapi.dto;

import com.bakari.restapi.constraint.ValidDateFormatConstraint;
import com.bakari.restapi.constraint.user.UniqueEmailConstraint;
import com.bakari.restapi.constraint.user.UniqueNameConstraint;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserPatchDto {

    @UniqueNameConstraint
    private String name;

    @Email(message = "Email should be valid")
    @UniqueEmailConstraint(message = "Email already exists")
    private String email;

    @Getter(AccessLevel.NONE)
    @ValidDateFormatConstraint
    private String dob;

    public LocalDate getDob() {
        return this.dob != null ? LocalDate.parse(dob) : LocalDate.now();
    }

    public boolean isEmpty() {
        return this.name == null && this.email == null && this.dob == null;
    }
}
