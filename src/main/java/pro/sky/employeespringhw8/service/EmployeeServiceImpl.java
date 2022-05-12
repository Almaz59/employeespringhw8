package pro.sky.employeespringhw8.service;

import org.springframework.stereotype.Service;
import pro.sky.employeespringhw8.data.Employee;
import pro.sky.employeespringhw8.exeptions.EmployeeAlreadyAddedExeption;
import pro.sky.employeespringhw8.exeptions.EmployeeNotFoundExeption;


import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(getId(firstName, lastName))) {
            throw new EmployeeAlreadyAddedExeption();
        } else{
            employees.put(getId(firstName, lastName), employee);
        }
        return employee;
    }

    @Override
    public final String getId(String firstName, String lastName) {
        String id = (firstName + lastName).toLowerCase();
        return id;
    }

    @Override
    public Map<String, Employee> showListOfEmployee() {
        return employees;
    }


    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(getId(firstName, lastName))) {
            employees.remove(getId(firstName, lastName));
            return employee;
        } else
            throw new EmployeeNotFoundExeption();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(getId(firstName, lastName))) {
            return employee;
        } else
            throw new EmployeeNotFoundExeption();
    }
}







