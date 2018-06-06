package com.spring.app.springbootjsonbinary.service;

import com.spring.app.springbootjsonbinary.entity.Author;
import com.spring.app.springbootjsonbinary.request.AddNewAuthorRequest;
import com.spring.app.springbootjsonbinary.request.UpdateAuthorRequest;

import java.util.List;

public interface AuthorService {

    List<Author> listAuthor();
    Author create(AddNewAuthorRequest requestAuthor);
    Author update(UpdateAuthorRequest requestAuthor);
}
