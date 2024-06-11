package com.codewithdurgesh.blog.service;

import java.util.List;

import com.codewithdurgesh.blog.payloads.PostDto;
import com.codewithdurgesh.blog.payloads.PostResponse;

public interface PostService {

//	create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
//	update
	PostDto updatePost(PostDto postDto, Integer postId);
	
//	delete
	void deltePost(Integer postId);
	
//	get all posts
	PostResponse getAllPost(Integer pageNumeber, Integer pageSize, String sortBy, String sortDir);
	
//	get single post
	PostDto getPostById(Integer postId);
	
//	get all posts by category
	List<PostDto> getPostsByCataegory(Integer categoryId);
	
//	get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
//	search posts
	List<PostDto> searchPosts(String keyword);
	
}
