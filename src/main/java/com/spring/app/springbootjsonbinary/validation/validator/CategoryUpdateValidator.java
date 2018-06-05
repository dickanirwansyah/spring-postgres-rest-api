package com.spring.app.springbootjsonbinary.validation.validator;

import com.spring.app.springbootjsonbinary.request.UpdateCategoryRequest;
import com.spring.app.springbootjsonbinary.validation.CategoryUpdateValidation;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CategoryUpdateValidator implements ConstraintValidator<CategoryUpdateValidation, UpdateCategoryRequest>{

    @Override
    public void initialize(CategoryUpdateValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(UpdateCategoryRequest value, ConstraintValidatorContext context) {
        if (value == null) return true;

        if (value.getCategoryId() == null || value.getCategoryId().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("categoryId must exits")
                    .addPropertyNode("categoryId")
                    .addConstraintViolation();
            return false;
        }

        if (value.getNameOfCategory() == null || value.getNameOfCategory().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("nameOfCategory must exists")
                    .addPropertyNode("nameOfCategory")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
