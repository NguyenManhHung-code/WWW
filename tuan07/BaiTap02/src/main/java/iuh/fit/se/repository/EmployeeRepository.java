package iuh.fit.se.repository;

import iuh.fit.se.enties.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
