/**
 * 
 */
package com.codewithdurgesh.blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.model.Comment;
import com.codewithdurgesh.blog.model.Post;
import com.codewithdurgesh.blog.payloads.CommentDto;
import com.codewithdurgesh.blog.repository.CommentRepo;
import com.codewithdurgesh.blog.repository.PostRepository;
import com.codewithdurgesh.blog.service.CommentService;


/**
 * @author mahes
 *
 */
@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepo commentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post = this.postRepository.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundException("post", "post id", postId));
		
		
		Comment comment= this.modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
	
		Comment savedComment = this.commentRepository.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment con = this.commentRepository.findById(commentId)
				.orElseThrow(()-> new ResourceNotFoundException("Comment", "CommentId", commentId));
		this.commentRepository.delete(con);
		
		
	}
	

}
