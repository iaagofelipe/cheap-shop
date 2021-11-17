package io.github.iaagofelipe;

import io.github.iaagofelipe.model.entity.Customer;
import io.github.iaagofelipe.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SalesApplication {

    @Bean
    public CommandLineRunner run(@Autowired CustomerRepository repository) {
        return args -> {
            Customer customer = Customer.builder().cpf("0000000000").name("Fulano").build();
            repository.save(customer);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }
}
