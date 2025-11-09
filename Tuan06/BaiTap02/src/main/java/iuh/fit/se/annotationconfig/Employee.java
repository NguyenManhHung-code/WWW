package iuh.fit.se.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    private int id = 301;
    private String name = "Pham Thi D";

    @Autowired
    private Address address;

    public void showInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
    }
}
