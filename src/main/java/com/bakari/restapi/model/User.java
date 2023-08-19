package com.bakari.restapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "users")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Setter
    @Column(name = "name")
    private String name;

    @Setter
    @Column(name = "email", unique = true)
    private String email;

    @Setter
    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Transient
    private int age;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updated_at;

    public User() {
    }

    public User(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + this.name + '\'' +
                ", email='" + this.email + '\'' +
                ", dob=" + this.dob +
                ", age=" + this.getAge() +
                '}';
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

}
