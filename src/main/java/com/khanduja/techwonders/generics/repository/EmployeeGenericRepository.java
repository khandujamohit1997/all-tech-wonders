package com.khanduja.techwonders.generics.repository;

import com.khanduja.techwonders.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeGenericRepository extends GenericRepository<Employee, String> {
}
