package com.boo.codingtest.comment.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.boo.codingtest.comment.Comment;
import com.boo.codingtest.comment.like.Like;
import com.boo.codingtest.comment.repository.CommentRepository;

@Service
public class CommentService {

	public CommentService(CommentRepository commentRepository) {
		super();
		this.commentRepository = commentRepository;
	}

	private CommentRepository commentRepository;

	public Comment addComment(Comment comment) {
		comment.setCreationDate(LocalDateTime.now());
		return commentRepository.save(comment);
	}

	public List<Comment> getAllCommentsByIdUserDestination(String idUserCreator) {
		return commentRepository.findAllByIdUserDestination(idUserCreator);
	}

	public Comment getCommentById(String idComment) {
		return commentRepository.findById(idComment).orElse(null);
	}

	public Comment updateVote(Comment comment, Like like) {

		List<Like> likes = comment.getLikesDetails() == null ? new ArrayList<Like>() : comment.getLikesDetails();

		if (likes.size() == 0) {
			likes.add(like);
			comment.setLikesDetails(likes);
		} else {
			Like updateLike = likes.stream().filter(x -> x.getIdUserCreator().equals(like.getIdUserCreator()))
					.findFirst().orElse(null);

			if (updateLike != null) {
				updateLike.setActive(!updateLike.isActive());
			} else {
				likes.add(like);
			}
		}

		int likesAmount = (int) likes.stream().filter(x -> x.isActive()).count();

		comment.setLikes(likesAmount);
		

		return commentRepository.save(comment);

	}
}
