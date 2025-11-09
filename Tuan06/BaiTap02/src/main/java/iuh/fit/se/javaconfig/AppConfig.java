package iuh.fit.se.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        return new Address("Da Nang", "Hai Chau", "Vietnam");
    }

    @Bean
    public Employee employee() {
        return new Employee(201, "Le Van C", address());
    }
}
