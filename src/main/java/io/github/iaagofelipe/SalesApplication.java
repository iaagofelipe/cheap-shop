package io.github.iaagofelipe;

import io.github.iaagofelipe.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SalesApplication {

    @Autowired
    @Qualifier("applicationName")
    public String applicationName;

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world";
    }


    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }
}
