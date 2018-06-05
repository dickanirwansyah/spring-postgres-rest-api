package com.spring.app.springbootjsonbinary.validation;


import com.spring.app.springbootjsonbinary.validation.validator.CategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.*;


@Target({ANNOTATION_TYPE, METHOD, TYPE, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {CategoryValidator.class})
@Documented
public @interface CategoryValidation {

    String message() default "CategoryValidation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
