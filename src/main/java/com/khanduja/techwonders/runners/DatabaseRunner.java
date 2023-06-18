package com.khanduja.techwonders.runners;

import com.khanduja.techwonders.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRunner implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        if (employeeRepository.findAll().isEmpty()) {
            return;
        }
        // Initialization.....
    }
}
