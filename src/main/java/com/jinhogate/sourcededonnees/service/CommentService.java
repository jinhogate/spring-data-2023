package com.jinhogate.sourcededonnees.service;

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
}
