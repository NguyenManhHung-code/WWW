package iuh.fit.se.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "First Name khong duoc phep rong")
    private String firstName;

    @NotEmpty(message = "Last Name khong duoc phep rong")
    private String lastName;
}
