package com.example.kursovayEnum;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployeeInList(@RequestParam("firstname") String firstName,
                                    @RequestParam("lastname") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployeeInList(@RequestParam("firstname") String firstName,
                                       @RequestParam("lastname") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee getEmployeeInList(@RequestParam("firstname") String firstName,
                                    @RequestParam("lastname") String lastName) {
        return employeeService.getEmployee(firstName,lastName);
    }
    @GetMapping()
    public Collection<Employee> allEmployeeInList() {
        return employeeService.findAll();
    }
}
