package com.example.kursovayEnum;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int salary, int department);

    Employee removeEmployee(String firstName, String lastName);

    Employee getEmployee(String firstName, String lastName);

    Collection<Employee> findAll();

    Employee maxSalaryDepartment(Integer department);


    Employee minSalaryDepartment(Integer department);

    List<Employee> allEmployeeInDepartment(Integer department);

    List<Employee> allEmployeeSeparationInDepartments();
}
