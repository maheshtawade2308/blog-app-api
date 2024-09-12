package com.codewithdurgesh.blog.service;

import com.codewithdurgesh.blog.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	public void deleteComment(Integer commentId);
}
