package com.khanduja.techwonders.validation.constraint;

import com.khanduja.techwonders.model.Employee;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

@Configuration
public class EmployeeSingleConstraintValidation {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    // Single Parameter Constraints
    public ResponseEntity<String> isDetailsValid(Employee employee) {
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
        String violation = violations.isEmpty() ? "Validated Successfully" :
            violations.stream().findFirst().map(ConstraintViolation::getMessage).toString();
        return new ResponseEntity<>(violation, HttpStatus.OK);
    }
}
