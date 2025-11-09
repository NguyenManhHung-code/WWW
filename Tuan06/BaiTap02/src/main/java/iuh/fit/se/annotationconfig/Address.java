package iuh.fit.se.annotationconfig;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private String city = "Ha Noi";
    private String state = "Cau Giay";
    private String country = "Vietnam";

    @Override
    public String toString() {
        return city + ", " + state + ", " + country;
    }
}
