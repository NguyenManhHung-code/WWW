package iuh.fit.se.services;

import iuh.fit.se.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public void save(Employee employee);
    public List<Employee> getAll();
    public Employee getById(Long id);
}
