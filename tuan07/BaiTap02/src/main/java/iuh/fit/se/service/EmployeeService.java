package iuh.fit.se.service;

import iuh.fit.se.enties.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    void update(Employee employee);
    void delete(int id);
    List<Employee> getAll();
    Employee getById(int id);
}
