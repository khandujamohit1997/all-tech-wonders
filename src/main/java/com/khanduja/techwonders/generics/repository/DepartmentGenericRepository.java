package com.khanduja.techwonders.generics.repository;

import com.khanduja.techwonders.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentGenericRepository extends GenericRepository<Department, String> {
}
