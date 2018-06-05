package com.spring.app.springbootjsonbinary.request;

import com.spring.app.springbootjsonbinary.validation.CategoryUpdateValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CategoryUpdateValidation
public class UpdateCategoryRequest {

    private String categoryId;

    private String nameOfCategory;
}
