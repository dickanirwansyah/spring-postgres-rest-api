package com.spring.app.springbootjsonbinary.validation;


import com.spring.app.springbootjsonbinary.validation.validator.CategoryUpdateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ANNOTATION_TYPE, METHOD, TYPE, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {CategoryUpdateValidator.class})
@Documented
public @interface CategoryUpdateValidation {

    String message() default "CategoryUpdateValidation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
