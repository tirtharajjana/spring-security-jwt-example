package com.example.springsecurityjwtexample;

import com.example.springsecurityjwtexample.entity.User;
import com.example.springsecurityjwtexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(1, "Alex", "1234", "alex@gmail.com"),
                new User(2, "John", "1234", "jhon@gmail.com"),
                new User(3, "Mary", "1234", "mary@gmail.com")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
    }

}
