package pro.sky.employeespringhw8.service;

import pro.sky.employeespringhw8.data.Employee;

import java.util.Map;

public interface EmployeeService {

    Employee add(String firstName, String lastName);

    String getId(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Map<String, Employee> showListOfEmployee();

}


