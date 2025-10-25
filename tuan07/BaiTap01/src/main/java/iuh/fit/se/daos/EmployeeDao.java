package iuh.fit.se.daos;

import iuh.fit.se.enties.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);
    List<Employee> getAll();
    Employee getByUserName(String userName);
    Employee getByUserNameDirectMapper(String userName);
}
