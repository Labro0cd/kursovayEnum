package com.example.kursovayEnum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "all")
    public String allEmployeeInList() {
        return employeeService.allEmployee();
    }

    @GetMapping(path = "/add")
    public String addEmployeeInList(@RequestParam("firstname") String firstName,
                                    @RequestParam("lastname") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public String removeEmployeeInList(@RequestParam("firstname") String firstName,
                                       @RequestParam("lastname") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public String getEmployeeInList(@RequestParam("firstname") String firstName,
                                    @RequestParam("lastname") String lastName) {
        return employeeService.getEmployee(firstName, lastName);
    }
}
