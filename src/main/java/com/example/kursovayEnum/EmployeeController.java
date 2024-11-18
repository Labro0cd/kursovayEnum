package com.example.kursovayEnum;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeServiceIml employeeService;

    public EmployeeController(EmployeeServiceIml employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployeeInList(@RequestParam("firstname") String firstName,
                                      @RequestParam("lastname") String lastName,
                                      @RequestParam("salary") int salary,
                                      @RequestParam("department") int department) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployeeInList(@RequestParam("firstname") String firstName,
                                         @RequestParam("lastname") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee getEmployeeInList(@RequestParam("firstname") String firstName,
                                      @RequestParam("lastname") String lastName) {
        return employeeService.getEmployee(firstName, lastName);
    }

    @GetMapping()
    public Collection<Employee> allEmployeeInList() {
        return employeeService.findAll();
    }

    @RequestMapping(path = "/employee/departments")
    @GetMapping(path = "/departments/max-salary")
    public Employee maxSalaryInDepartment(@RequestParam("department") Integer department) {
        return employeeService.maxSalaryDepartment(department);
    }

    @GetMapping(path = "/departments/min-salary")
    public Employee mixSalaryInDepartment(@RequestParam("department") Integer department) {
        return employeeService.minSalaryDepartment(department);
    }

    @GetMapping("/all")
    public List<Employee> allEmployeeInDepartment(@RequestParam("department") Integer department) {
        return employeeService.allEmployeeInDepartment(department);
    }

    @GetMapping(path = "/departments/all")
    public List<Employee> allEmployeeSeparationInDepartment() {
        return employeeService.allEmployeeSeparationInDepartments();
    }
}
