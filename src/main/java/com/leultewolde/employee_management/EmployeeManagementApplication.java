package com.leultewolde.employee_management;

import com.leultewolde.employee_management.model.Employee;
import com.leultewolde.employee_management.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeManagementApplication implements CommandLineRunner {

    private final EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        // Creating Employees
        employeeService.createEmployee(new Employee("John", "Doe", 50000));
        employeeService.createEmployee(new Employee("Jane", "Dona", 50000));
        employeeService.createEmployee(new Employee("Alice", "Smith", 60000));
        employeeService.createEmployee(new Employee("Bob", "Brown", 45000));

        // get all employees and print
        String result = employeeService.getAllEmployees().stream()
                .map(Employee::toString)
                .collect(Collectors.joining(", \n"));
        System.out.println(result);
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

}
