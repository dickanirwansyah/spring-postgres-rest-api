package com.spring.app.springbootjsonbinary.request;

import com.spring.app.springbootjsonbinary.validation.AuthorUpdateValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AuthorUpdateValidation
public class UpdateAuthorRequest {

    private String authorId;
    private String authorName;
}
