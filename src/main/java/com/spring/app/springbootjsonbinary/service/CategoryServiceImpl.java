package com.spring.app.springbootjsonbinary.service;

import com.spring.app.springbootjsonbinary.entity.Category;
import com.spring.app.springbootjsonbinary.repository.CategoryRepository;
import com.spring.app.springbootjsonbinary.request.AddNewCategoryRequest;
import com.spring.app.springbootjsonbinary.request.GetDetailsCategory;
import com.spring.app.springbootjsonbinary.request.UpdateCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategory() {
        List<Category> list = new ArrayList<>();
        for(Category category: categoryRepository.findAll()){
            list.add(category);
        }
        return list;
    }

    @Override
    public Category createCategory(AddNewCategoryRequest addNewCategoryRequest) {
        Category category = newCategory(addNewCategoryRequest.getNameOfCategory());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(UpdateCategoryRequest updateCategoryRequest) {
        Category category = editCategory(updateCategoryRequest.getCategoryId(),
                updateCategoryRequest.getNameOfCategory());
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getDetailCategory(GetDetailsCategory getDetailsCategory) {
        return categoryRepository.findById(getDetailsCategory.getCategoryId());
    }

    private Category editCategory(String categoryId, String nameCategory){
        return Category.builder()
                .idcategory(categoryId)
                .name(nameCategory)
                .build();
    }

    private Category newCategory(String name){
        return Category.builder()
                .name(name)
                .build();
    }
}
