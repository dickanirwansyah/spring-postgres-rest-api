package com.spring.app.springbootjsonbinary.validation.validator;

import com.spring.app.springbootjsonbinary.request.AddNewCategoryRequest;
import com.spring.app.springbootjsonbinary.validation.CategoryValidation;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CategoryValidator implements ConstraintValidator<CategoryValidation, AddNewCategoryRequest>{


    @Override
    public void initialize(CategoryValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(AddNewCategoryRequest value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        if (value.getNameOfCategory() == null || value.getNameOfCategory().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("nama masih kosong")
                    .addPropertyNode("nameOfCategory").addConstraintViolation();
            return false;
        }

        return true;
    }
}
