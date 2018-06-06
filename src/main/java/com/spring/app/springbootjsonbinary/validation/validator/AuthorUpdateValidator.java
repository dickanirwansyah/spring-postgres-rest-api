package com.spring.app.springbootjsonbinary.validation.validator;

import com.spring.app.springbootjsonbinary.entity.Author;
import com.spring.app.springbootjsonbinary.exception.BadRequestException;
import com.spring.app.springbootjsonbinary.repository.AuthorRepository;
import com.spring.app.springbootjsonbinary.request.UpdateAuthorRequest;
import com.spring.app.springbootjsonbinary.validation.AuthorUpdateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
public class AuthorUpdateValidator implements ConstraintValidator<AuthorUpdateValidation, UpdateAuthorRequest>{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void initialize(AuthorUpdateValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(UpdateAuthorRequest value, ConstraintValidatorContext context) {
        if (value == null) return true;

        if (value.getAuthorId() == null || value.getAuthorId().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("maaf kode masih kosong")
                    .addPropertyNode("authorId")
                    .addConstraintViolation();
            return false;
        }

        Optional<Author> author = authorRepository.findById(value.getAuthorId());
        if (!author.isPresent()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("maaf kode ini tidak ada")
                    .addPropertyNode("authorId")
                    .addConstraintViolation();
            return false;
        }

        if (value.getAuthorName() == null || value.getAuthorName().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("maaf nama masih kosong")
                    .addPropertyNode("authorName")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
