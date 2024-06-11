package com.codewithdurgesh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithdurgesh.blog.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
