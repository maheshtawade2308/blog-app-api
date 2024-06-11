package com.codewithdurgesh.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithdurgesh.blog.model.Category;
import com.codewithdurgesh.blog.model.Post;
import com.codewithdurgesh.blog.model.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String keyword);
	
//	@Query("select p from post p where p.title like : key")
//	List<Post> searchByTitle(@Param("key") String keyword);
}
