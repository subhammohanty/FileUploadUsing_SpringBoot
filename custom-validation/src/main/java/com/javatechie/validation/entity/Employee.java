package com.javatechie.validation.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javatechie.validation.customValidation.ValidateEmployeeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private int empId;

    @NotBlank(message = "FirstName should not be null or empty")
    private String firstName;

    @NotBlank(message = "LastName should not be null or empty")
    private String lastName;

    @Past(message = "Start should not be before current date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date doj;

    @NotNull(message = "Dept cannot be null")
    @NotEmpty(message = "Dept cannot be Emmpty")
    private String dept;

    @Email(message = "Invalid Email Id")
    private String email;

    //custom validation
    @ValidateEmployeeType
    private String employeeType;
}
