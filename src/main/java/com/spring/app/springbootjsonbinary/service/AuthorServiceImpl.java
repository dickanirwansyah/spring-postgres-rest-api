package com.spring.app.springbootjsonbinary.service;

import com.spring.app.springbootjsonbinary.entity.Author;
import com.spring.app.springbootjsonbinary.exception.BadRequestException;
import com.spring.app.springbootjsonbinary.repository.AuthorRepository;
import com.spring.app.springbootjsonbinary.request.AddNewAuthorRequest;
import com.spring.app.springbootjsonbinary.request.UpdateAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> listAuthor() {
        List<Author> list = new ArrayList<>();
        for(Author author : authorRepository.findAll()){
            list.add(author);
        }
        return list;
    }

    @Override
    public Author create(AddNewAuthorRequest requestAuthor) {
        Author author = newAuthor(requestAuthor.getAuthorName());
        return authorRepository.save(author);
    }

    @Override
    public Author update(UpdateAuthorRequest requestAuthor) {
        Author author = editAuthor(requestAuthor.getAuthorId(),
                requestAuthor.getAuthorName());
        return authorRepository.save(author);
    }

    private Author editAuthor(String id, String name){
        return Author.builder()
                .idauthor(id)
                .name(name)
                .build();
    }

    private Author newAuthor(String name){
        return Author.builder()
                .name(name)
                .build();
    }
}
