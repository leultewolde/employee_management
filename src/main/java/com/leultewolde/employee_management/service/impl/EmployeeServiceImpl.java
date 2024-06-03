package com.leultewolde.employee_management.service.impl;

import com.leultewolde.employee_management.model.Employee;
import com.leultewolde.employee_management.repository.EmployeeRepository;
import com.leultewolde.employee_management.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = repository.findAll();
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getLastname, Comparator.reverseOrder()))
                .toList();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        repository.findById(employee.getId()).ifPresent(repository::delete);
    }
}
