package com.khanduja.techwonders.generics.controller;

import com.khanduja.techwonders.generics.services.DepartmentGenericService;
import com.khanduja.techwonders.model.Department;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/generic/department/")
public class DepartmentGenericController {

    @Autowired
    private DepartmentGenericService departmentGenericService;

    @PostMapping("add")
    public Department addDepartment(@RequestBody @Valid Department department) {
        return departmentGenericService.save(department);
    }

    @GetMapping("get")
    public List<Department> getAllDepartmentDetails() {
        return departmentGenericService.findAll();
    }
}
