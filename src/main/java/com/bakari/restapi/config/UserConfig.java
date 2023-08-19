package com.bakari.restapi.config;

import com.bakari.restapi.model.User;
import com.bakari.restapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {

        return args -> {
            var painter1 = new User("Salvador", "salvadordali@painter.com", LocalDate.of(1904, Month.MAY, 11));
            var painter2 = new User("Frida", "fridakahlo@gmail.com", LocalDate.of(1907, Month.JULY, 6));
            
            userRepository.saveAll(List.of(painter1, painter2));
        };
    }

}
