package pro.sky.employeespringhw8.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.employeespringhw8.data.Employee;
import pro.sky.employeespringhw8.service.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName) {
        return employeeService.add(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/list")
    public Map<String, Employee> showListOfEmployee() {
        return employeeService.showListOfEmployee();
    }
}
