package com.khanduja.techwonders.generics.services.impl;

import com.khanduja.techwonders.generics.repository.GenericRepository;
import com.khanduja.techwonders.generics.services.EmployeeGenericService;
import com.khanduja.techwonders.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeGenericServiceImpl
    extends GenericImplementation<Employee, String> implements EmployeeGenericService {

    public EmployeeGenericServiceImpl() {
    }

    @Autowired
    public EmployeeGenericServiceImpl(GenericRepository<Employee, String> genericRepository) {
        super(genericRepository);
    }
}
