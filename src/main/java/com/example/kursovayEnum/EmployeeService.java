package com.example.kursovayEnum;

import Exception.EmployeeNotFoundException;
import Exception.EmployeeStorageIsFullException;
import Exception.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    static final Integer maxEmployee = 10;
    private final List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employeeList.size()>= maxEmployee) {
            throw new EmployeeStorageIsFullException();
        }
        employeeList.add(employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee getEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeeList);
    }
}
