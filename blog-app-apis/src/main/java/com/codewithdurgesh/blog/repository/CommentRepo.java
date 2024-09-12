package com.codewithdurgesh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithdurgesh.blog.model.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}