package com.javatechie.validation.customValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmployeeTypeValidator.class)
public @interface ValidateEmployeeType {

    public String message() default "Invalid Employee Type: It should be either permanent or vendor";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
