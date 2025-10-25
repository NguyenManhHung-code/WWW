package iuh.fit.se;

import iuh.fit.se.daos.EmployeeDao;
import iuh.fit.se.enties.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"iuh.fit.se.daos","iuh.fit.se.daos.impl"})
public class BaiTap01Application {
    public static void main(String[] args) {
        SpringApplication.run(BaiTap01Application.class, args);
    }
    @Bean
    CommandLineRunner runner (EmployeeDao employeeDao){
        return args -> {
            Employee employee = new Employee("NguyenManhHung","21001595");
            employeeDao.save(employee);
            List<Employee> employees = employeeDao.getAll();
            employees.forEach(System.out::println);
            Employee employee2 = employeeDao.getByUserName("NguyenManhHung");
            System.out.println(employee2);
            Employee employeeDirec = employeeDao.getByUserNameDirectMapper("NguyenManhHung");
            System.out.println(employeeDirec);
        };
    }
}
