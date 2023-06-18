package com.khanduja.techwonders.spring_boot;

import com.khanduja.techwonders.configuration.beans.ModelBeanConfiguration;
import com.khanduja.techwonders.model.Department;
import com.khanduja.techwonders.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ModelBeanConfiguration.class)
public class BeansScopeTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Employee primaryEmployeeInstance;

    @Autowired
    @Qualifier("EmployeeSingletonBean")
    Employee employeeSingletonInstance1;

    @Autowired
    @Qualifier("EmployeeSingletonBean")
    Employee employeeSingletonInstance2;

    @Autowired
    @Qualifier("EmployeePrototypeBean")
    Employee employeePrototypeInstance1;

    @Autowired
    @Qualifier("EmployeePrototypeBean")
    Employee employeePrototypeInstance2;

    @Test
    public void singletonScopeTest() {

        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("beans_scopes.xml");

        Employee employeeInstanceA = (Employee) applicationContext.getBean("employeeInstance");
        Employee employeeInstanceB = (Employee) applicationContext.getBean("employeeInstance");

        employeeInstanceA.setFirstName("Mohit");
        assertEquals("Mohit", employeeInstanceB.getFirstName());
    }

    @Test
    public void prototypeScopeTest() {

        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("beans_scopes.xml");

        Department departmentInstanceA = (Department) applicationContext.getBean("departmentInstance");
        Department departmentInstanceB = (Department) applicationContext.getBean("departmentInstance");

        departmentInstanceA.setName("Technical");
        assertNotEquals("Technical", departmentInstanceB.getName());
    }

    @Test
    public void sameClassBeansTest() {
        employeeSingletonInstance1.setFirstName("Mohit-1");
        assertEquals("Mohit-1", employeeSingletonInstance2.getFirstName());

        employeePrototypeInstance1.setFirstName("Mohit-1");
        assertNotEquals("Mohit-1", employeePrototypeInstance2.getFirstName());
    }

    @Test
    public void sameClassPrimaryBeanTest() {
        primaryEmployeeInstance.setFirstName("Mohit-1");
        assertEquals("Mohit-1", primaryEmployeeInstance.getFirstName());
    }
}
