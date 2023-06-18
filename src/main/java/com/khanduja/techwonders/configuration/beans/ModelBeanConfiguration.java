package com.khanduja.techwonders.configuration.beans;

import com.khanduja.techwonders.model.Employee;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class ModelBeanConfiguration {

    @Primary
    @Bean(name = "EmployeeSingletonBean")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Employee employeeInstance1() {
        return new Employee();
    }

    @Bean(name = "EmployeePrototypeBean")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Employee employeeInstance2() {
        return new Employee();
    }
}
