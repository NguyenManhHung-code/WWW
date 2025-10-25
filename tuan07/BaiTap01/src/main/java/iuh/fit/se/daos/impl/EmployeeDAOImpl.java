package iuh.fit.se.daos.impl;

import iuh.fit.se.daos.EmployeeDao;
import iuh.fit.se.enties.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employees (user_name, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getUserName(), employee.getPassword());
    }

    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public Employee getByUserName(String userName) {
        String sql = "SELECT * FROM employees WHERE user_name = ?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), userName);
    }

    @Override
    public Employee getByUserNameDirectMapper(String userName) {
        String sql = "SELECT * FROM employees WHERE user_name = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Employee emp = new Employee();
            emp.setUserName(rs.getString("user_name"));
            emp.setPassword(rs.getString("password"));
            return emp;
        }, userName);
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee emp = new Employee();
            emp.setUserName(rs.getString("user_name"));
            emp.setPassword(rs.getString("password"));
            return emp;
        }
    }
}
