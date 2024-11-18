package com.example.kursovayEnum;

import Exception.EmployeeNotFoundException;
import Exception.EmployeeStorageIsFullException;
import Exception.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceIml implements EmployeeService {
    static final Integer maxEmployee = 10;
    private final Map<String, Employee> employeeList = new HashMap<>();
    private final List<Integer> departments = new ArrayList<>(List.of(1, 2, 3, 4, 5));

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employeeList.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employeeList.size() >= maxEmployee) {
            throw new EmployeeStorageIsFullException();
        }
        if (!departments.contains(employee.getDepartment())) {
            throw new RuntimeException("Not found department");
        }
        employeeList.put(firstName + lastName, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsKey(firstName + lastName)) {
            employeeList.remove(firstName + lastName);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee getEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsKey(firstName + lastName)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeList.values();
    }

    @Override
    public Employee maxSalaryDepartment(Integer department) {
        List<Employee> depart = employeeList.values().stream()
                .filter(e -> e.getDepartment().equals(department))
                .toList();
        Optional<Employee> maxSalaryInDepartment = depart.stream().max((e, p) -> e.getSalary().compareTo(p.getSalary()));
        return maxSalaryInDepartment.get();
    }

    @Override
    public Employee minSalaryDepartment(Integer department) {
        List<Employee> depart = employeeList.values().stream()
                .filter(e -> e.getDepartment().equals(department))
                .toList();
        Optional<Employee> maxSalaryInDepartment = depart.stream().min((e, p) -> e.getSalary().compareTo(p.getSalary()));
        return maxSalaryInDepartment.get();
    }

    @Override
    public List<Employee> allEmployeeInDepartment(Integer department) {
        return employeeList.values().stream()
                .filter(e -> e.getDepartment().equals(department))
                .toList();
    }

    @Override
    public List<Employee> allEmployeeSeparationInDepartments() {
        List<Employee> result = new ArrayList<>(List.of());
        for (int i = 0; i < departments.size(); i++) {
            int finalI = i;
            result.addAll(employeeList.values().stream()
                    .filter((e) -> {
                        return e.getDepartment().equals(departments.get(finalI));
                    })
                    .toList()
            );

        }
        return result;
    }


}
