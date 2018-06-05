package com.spring.app.springbootjsonbinary.service;

import com.spring.app.springbootjsonbinary.entity.Category;
import com.spring.app.springbootjsonbinary.request.AddNewCategoryRequest;
import com.spring.app.springbootjsonbinary.request.GetDetailsCategory;
import com.spring.app.springbootjsonbinary.request.UpdateCategoryRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> listCategory();
    Category createCategory(AddNewCategoryRequest addNewCategoryRequest);
    Category updateCategory(UpdateCategoryRequest updateCategoryRequest);
    Optional<Category> getDetailCategory(GetDetailsCategory getDetailsCategory);
}
