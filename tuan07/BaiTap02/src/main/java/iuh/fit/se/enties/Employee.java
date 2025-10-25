package iuh.fit.se.enties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  int id;
    private String role;
    private String name;
    public Employee(String role, String name) {
        this.role = role;
        this.name = name;
    }
}
