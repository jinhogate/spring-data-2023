package com.jinhogate.sourcededonnees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jinhogate.sourcededonnees.model.Comment;
import com.jinhogate.sourcededonnees.repository.CommentRepository;

@Service
public class CommentService {

	private CommentRepository commentRepository;
	
	public CommentService (CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public Optional<Comment> getOneCommentById(Integer id){
		return this.commentRepository.findById(id);
	}
	
	public Comment addComment(Comment comment) {
		return this.commentRepository.save(comment);
	}
	
	public List<Comment> getAllComments(){
		return this.commentRepository.findAll();
	}
	
	public void deleteComment(Integer id) {
		this.commentRepository.deleteById(id);
	}
	
	public Comment saveComment(Comment comment) {
		return this.commentRepository.save(comment);
	}
}
