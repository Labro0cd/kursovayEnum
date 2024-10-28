package com.example.kursovayEnum;

import Exception.EmployeeNotFoundException;
import Exception.EmployeeStorageIsFullException;
import Exception.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    static final Integer maxEmployee = 10;
    private final List<Employee> employeeList = new ArrayList<>();

    public String addEmployee(String firstName, String lastName) {
        try {
            if (employeeList.size() >= maxEmployee)
                throw new EmployeeStorageIsFullException("Штат сотрудников переполнен.");
            for (Employee employee : employeeList) {
                if (firstName.equals(employee.getFirstName()) &
                        lastName.equals(employee.getLastName())) {
                    throw new EmployeeAlreadyAddedException("Этот сотрудник уже добавлен!");
                }
            }
            Employee employee = new Employee(firstName, lastName);
            employeeList.add(employee);
            return employee.toString();
        } catch (EmployeeStorageIsFullException | EmployeeAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }
        return "Невозможно добавить.";
    }

    public String removeEmployee(String firstName, String lastName) {
        try {
            for (Employee employee : employeeList) {
                if (firstName.equals(employee.getFirstName()) &
                        lastName.equals(employee.getLastName())) {
                    employeeList.remove(employee);
                    return "Сотрудник удален.";
                }
            }
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return "Сотрудник не найден";
    }

    public String getEmployee(String firstName, String lastName) {
        try {
            for (Employee employee : employeeList) {
                if (firstName.equals(employee.getFirstName()) &
                        lastName.equals(employee.getLastName())) {
                    return employee.toString();
                }
            }
            throw new EmployeeNotFoundException("Сотрудник не найденю");
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return "Сотрудник не найден.";
    }

    public String allEmployee() {
        return employeeList.toString();
    }
}
