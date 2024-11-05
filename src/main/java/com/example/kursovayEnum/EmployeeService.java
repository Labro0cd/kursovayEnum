package com.example.kursovayEnum;

import Exception.EmployeeNotFoundException;
import Exception.EmployeeStorageIsFullException;
import Exception.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    static final Integer maxEmployee = 10;
    private final Map<String,Employee> employeeList = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsKey(firstName+lastName)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employeeList.size()>= maxEmployee) {
            throw new EmployeeStorageIsFullException();
        }
        employeeList.put(firstName+lastName,employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsKey(firstName+lastName)) {
            employeeList.remove(firstName+lastName);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee getEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsKey(firstName+lastName)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> findAll() {
        return employeeList.values();
    }
}
