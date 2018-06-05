package com.spring.app.springbootjsonbinary.controller;

import com.spring.app.springbootjsonbinary.entity.Category;
import com.spring.app.springbootjsonbinary.request.AddNewCategoryRequest;
import com.spring.app.springbootjsonbinary.request.GetDetailsCategory;
import com.spring.app.springbootjsonbinary.request.UpdateCategoryRequest;
import com.spring.app.springbootjsonbinary.response.ErrorResponse;
import com.spring.app.springbootjsonbinary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/category")
public class ControllerCategory {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listCategory(){
        return Optional.ofNullable(categoryService.listCategory())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Category> create(@Valid @RequestBody AddNewCategoryRequest request){
        return Optional.ofNullable(categoryService.createCategory(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Category> update(@Valid @RequestBody UpdateCategoryRequest request){
        return Optional.ofNullable(categoryService.updateCategory(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<Optional<Category>> getDetail(@Valid @PathVariable String categoryId){
        GetDetailsCategory getId = GetDetailsCategory
                .builder().categoryId(categoryId).build();

        Optional<Category> category = categoryService.getDetailCategory(getId);
        if(!category.isPresent()){
            return new ResponseEntity<Optional<Category>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Optional<Category>>(category, HttpStatus.OK);
    }

    //validation
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlingError(MethodArgumentNotValidException exception){

        String errorMessage = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(exception.getMessage());

        return ErrorResponse.builder()
                .message(errorMessage)
                .status(false)
                .tanggal(new Date())
                .build();

    }

}
