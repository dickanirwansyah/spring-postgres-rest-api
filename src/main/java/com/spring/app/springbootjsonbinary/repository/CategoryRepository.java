package com.spring.app.springbootjsonbinary.repository;

import com.spring.app.springbootjsonbinary.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
