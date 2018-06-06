package com.spring.app.springbootjsonbinary.repository;

import com.spring.app.springbootjsonbinary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, String>{

    Optional<Author> findByName(String name);
}
