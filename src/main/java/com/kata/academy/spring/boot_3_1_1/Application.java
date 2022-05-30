package com.kata.academy.spring.boot_3_1_1;


import com.kata.academy.spring.boot_3_1_1.model.User;
import com.kata.academy.spring.boot_3_1_1.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private UserRepository userRepository;

    @Autowired
    public Application(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            userRepository.save(new User("John", "Davis", "IT", 4500));
            userRepository.save(new User("Fred", "Miller", "HR", 800));
            userRepository.save(new User("Samuel", "Walker", "Sales", 2000));
            userRepository.save(new User("Harry", "Jackson", "Accounting department", 1600));
            userRepository.save(new User("William", "Moore", "Customer service", 900));
        };
    }
}

