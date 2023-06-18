package com.khanduja.techwonders.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "`Department`")
public class Department {

    @Id
    private String departmentCode;

    @NotBlank(message = "name shouldn't be blank")
    private String name;

    @Min(value = 18000, message = "Employees shouldn't be less than 18K")
    @Max(value = 20000, message = "Employees shouldn't be greater than 20K")
    private int totalEmployees;

    @Email(message = "Email should be valid")
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @PastOrPresent
    private Date startDate;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Department department)) return false;
        if (o == this) return true;
        return Objects.equals(this.departmentCode, department.departmentCode);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        if (Objects.nonNull(this.departmentCode)) {
            return 31 * hash + departmentCode.hashCode();
        }
        return hash;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Department departmentInstance() {
        return new Department();
    }
}
