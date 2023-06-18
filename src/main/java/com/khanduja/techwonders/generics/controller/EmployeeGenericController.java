package com.khanduja.techwonders.generics.controller;

import com.khanduja.techwonders.generics.services.EmployeeGenericService;
import com.khanduja.techwonders.model.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/generic/employees/")
public class EmployeeGenericController {

    // TODO: 07/06/23 Encoding and Sanitization, Content Security Policy (CSP), HTTP Header Security,

    @Autowired
    private EmployeeGenericService employeeGenericService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee) {
        Employee createdEmployee = employeeGenericService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeGenericService.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String id) {
        return employeeGenericService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        return employeeGenericService.update(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
        return employeeGenericService.delete(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updatePartially(@PathVariable String id, @RequestBody Map<String, Object> toUpdateFields) {
        return employeeGenericService.updatePartially(id, toUpdateFields, Employee.class);
    }
}
