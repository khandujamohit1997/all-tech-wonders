package com.khanduja.techwonders.generics.services.impl;

import com.khanduja.techwonders.generics.repository.GenericRepository;
import com.khanduja.techwonders.generics.services.DepartmentGenericService;
import com.khanduja.techwonders.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentGenericServiceImpl extends GenericImplementation<Department, String>
    implements DepartmentGenericService {

    @Autowired(required = false)
    public DepartmentGenericServiceImpl(GenericRepository<Department, String> genericRepository) {
        super(genericRepository);
    }
}
