package iuh.fit.se.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AppConfig {
    @Bean
    public Engine engine() {
        return new ICEngine(); // Đổi sang new HybridEngine() nếu muốn
    }
    @Bean
    public Car car() {
        Car car = new Car();
        car.setEngine(engine());
        return car;
    }
}
