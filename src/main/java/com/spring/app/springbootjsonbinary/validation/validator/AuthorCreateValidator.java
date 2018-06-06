package com.spring.app.springbootjsonbinary.validation.validator;

import com.spring.app.springbootjsonbinary.request.AddNewAuthorRequest;
import com.spring.app.springbootjsonbinary.validation.AuthorCreateValidation;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class AuthorCreateValidator implements ConstraintValidator<AuthorCreateValidation, AddNewAuthorRequest>{


    @Override
    public void initialize(AuthorCreateValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(AddNewAuthorRequest value, ConstraintValidatorContext context) {
        if (value == null) return true;

        if (value.getAuthorName() == null || value.getAuthorName().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("name author must exists")
                    .addPropertyNode("authorName")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
