package com.spring.app.springbootjsonbinary.request;

import com.spring.app.springbootjsonbinary.validation.CategoryValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CategoryValidation
public class AddNewCategoryRequest {

    private String nameOfCategory;
}
