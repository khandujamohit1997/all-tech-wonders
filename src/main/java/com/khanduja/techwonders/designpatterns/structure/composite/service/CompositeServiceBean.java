package com.khanduja.techwonders.designpatterns.structure.composite.service;

import com.khanduja.techwonders.designpatterns.structure.composite.model.Employee;
import com.khanduja.techwonders.designpatterns.structure.composite.model.impl.Developer;
import com.khanduja.techwonders.designpatterns.structure.composite.model.impl.Manager;
import org.springframework.stereotype.Service;

@Service
public class CompositeServiceBean {

    public void printOrganizationHierarchy() {
        Employee developer1 = new Developer("John Doe", "Senior Developer");
        Employee developer2 = new Developer("Jane Smith", "Junior Developer");

        Manager manager = new Manager("Alice Johnson", "Project Manager");
        manager.addEmployee(developer1);
        manager.addEmployee(developer2);

        Employee developer3 = new Developer("Mark Williams", "Senior Developer");

        Manager seniorManager = new Manager("Bob Thompson", "Senior Project Manager");
        seniorManager.addEmployee(manager);
        seniorManager.addEmployee(developer3);

        seniorManager.displayDetails();
    }
}
