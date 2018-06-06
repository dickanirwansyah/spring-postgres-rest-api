package com.spring.app.springbootjsonbinary.request;

import com.spring.app.springbootjsonbinary.validation.AuthorCreateValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AuthorCreateValidation
public class AddNewAuthorRequest {

    private String authorName;
}
