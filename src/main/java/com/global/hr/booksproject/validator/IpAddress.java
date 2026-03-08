package com.global.hr.booksproject.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.lang.reflect.Field;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {IpAddressImp.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface IpAddress {

    String message() default "{validation.constraints.ip-address.message}";

    Class<?>[] groups() default { };

    Class<? extends  Payload>[] payload() default { };
}
