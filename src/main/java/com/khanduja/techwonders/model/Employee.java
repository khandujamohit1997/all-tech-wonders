package com.khanduja.techwonders.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "`Employee`")
public class Employee {

    @Id
    private String EmpCode;

    @NotBlank(message = "first-name shouldn't be blank")
    private String firstName;

    @NotBlank(message = "first-name shouldn't be blank")
    private String lastName;

    @AssertTrue
    private boolean employed;

    @Min(value = 18000, message = "Salary shouldn't be less than 18K")
    @Max(value = 20000, message = "Salary shouldn't be greater than 20K")
    private int salary;

    @Email(message = "Email should be valid")
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @PastOrPresent
    private Date joining;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @FutureOrPresent
    @Nullable
    private Date resign;

    @NotNull(message = "values shouldn't be null")
    private List<@NotBlank String> skills;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        if (o == this) return true;
        return Objects.equals(this.EmpCode, employee.EmpCode);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        if (Objects.nonNull(this.EmpCode)) {
            return 31 * hash + EmpCode.hashCode();
        }
        return hash;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Employee employeeInstance() {
        return new Employee();
    }
}
