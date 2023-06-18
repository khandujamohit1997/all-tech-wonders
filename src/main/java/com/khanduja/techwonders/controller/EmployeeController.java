package com.khanduja.techwonders.controller;

import com.khanduja.techwonders.model.Employee;
import com.khanduja.techwonders.validation.constraint.EmployeeSingleConstraintValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {

    @Autowired
    EmployeeSingleConstraintValidation employeeSingleConstraintValidation;

    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody Employee employee) {
        return employeeSingleConstraintValidation.isDetailsValid(employee);
    }

    @GetMapping("get")
    public Employee getEmployeeDetails() {
        Employee employee = new Employee();
        employee.setFirstName("Mohit");
        employee.setLastName("Khanduja");
        return employee;
    }
}
