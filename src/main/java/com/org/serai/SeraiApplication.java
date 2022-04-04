package com.org.serai;

import com.org.serai.order.repository.OrderRepository;
import com.org.serai.order.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class, OrderRepository.class})
public class SeraiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeraiApplication.class, args);
    }

}
