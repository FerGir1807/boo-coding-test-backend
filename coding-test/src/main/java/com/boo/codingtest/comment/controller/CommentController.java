package com.boo.codingtest.comment.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boo.codingtest.comment.Comment;
import com.boo.codingtest.comment.EnneagramEnum;
import com.boo.codingtest.comment.MbtiEnum;
import com.boo.codingtest.comment.SortEnum;
import com.boo.codingtest.comment.ZodiacEnum;
import com.boo.codingtest.comment.like.Like;
import com.boo.codingtest.comment.service.CommentService;
import com.boo.codingtest.httpresponse.ResponseHandler;
import com.boo.codingtest.user.service.UserService;

import jakarta.validation.Valid;

@RestController
public class CommentController {

	private static final String MESSAGE_INVALID_ZODIAC_FILTERING_VALUE = "Invalid zodiac filtering value";
	private static final String MESSAGE_INVALID_ENNEAGRAM_FILTERING_VALUE = "Invalid enneagram filtering value";
	private static final String MESSAGE_INVALID_MBTI_FILTERING_VALUE = "Invalid mbti filtering value";
	private static final String MESSAGE_INVALID_SORTING_VALUE = "Invalid sorting value";
	private static final String MESSAGE_NO_COMMENT = "No comment found.";
	private static final String MESSAGE_COMMENT_UPDATED = "Comment updated successfully.";
	private static final String MESSAGE_NO_COMMENTS = "No comments found.";
	private static final String MESSAGE_COMMENTS_FOUND = "Comments found.";
	private static final String MESSAGE_NO_USER = "No user found.";
	private static final String MESSAGE_COMMENT_CREATED = "Comment created successfully.";

	public CommentController(CommentService commentService, UserService userService) {
		super();
		this.commentService = commentService;
		this.userService = userService;
	}

	private CommentService commentService;
	private UserService userService;

	@PostMapping(path = "/users/{idUserCreator}/comments")
	public ResponseEntity<Object> addComment(@PathVariable String idUserCreator, @Valid @RequestBody Comment comment,
			BindingResult result) {

		if (result.hasErrors()) {

			return ResponseHandler.response(result.getAllErrors().toString(), HttpStatus.OK, null);

		} else {
			if (userService.getUserById(idUserCreator) == null
					|| userService.getUserById(comment.getIdUserDestination()) == null) {
				return ResponseHandler.response(MESSAGE_NO_USER, HttpStatus.OK, null);
			} else {
				Comment newComment = commentService.addComment(comment);

				return ResponseHandler.response(MESSAGE_COMMENT_CREATED, HttpStatus.OK, newComment);
			}
		}
	}

	@GetMapping(path = "/users/{idUserDestination}/comments")
	public ResponseEntity<Object> getAllComentsByIdUserDestination(@PathVariable String idUserDestination) {

		List<Comment> comments = commentService.getAllCommentsByIdUserDestination(idUserDestination);
		if (comments.isEmpty()) {
			return ResponseHandler.response(MESSAGE_NO_COMMENTS, HttpStatus.OK, null);
		} else {
			return ResponseHandler.response(MESSAGE_COMMENTS_FOUND, HttpStatus.OK, comments);
		}

	}

	@GetMapping(path = "/users/{idUserDestination}/comments/sorting-filtering")
	public ResponseEntity<Object> getAllComentsFilteringSort(@PathVariable String idUserDestination,
			@RequestParam(required = false) String sort, @RequestParam(required = false) String mbti,
			@RequestParam(required = false) String enneagram, @RequestParam(required = false) String zodiac) {

		List<Comment> comments = commentService.getAllCommentsByIdUserDestination(idUserDestination);

		if (sort != null) {
			if (SortEnum.getEnum(sort) == null) {
				return ResponseHandler.response(MESSAGE_INVALID_SORTING_VALUE, HttpStatus.BAD_REQUEST, null);
			} else {
				if (sort.equals(SortEnum.BEST.getValue())) {
					comments.sort(Comparator.comparing(Comment::getLikes));
				} else {
					comments.sort(Comparator.comparing(Comment::getCreationDate));
				}
				Collections.reverse(comments);
			}
		}

		if (mbti != null) {
			if (MbtiEnum.getEnum(mbti) == null) {
				return ResponseHandler.response(MESSAGE_INVALID_MBTI_FILTERING_VALUE, HttpStatus.BAD_REQUEST, null);
			} else {
				comments = comments.stream().filter(x -> mbti.equals(x.getMbti())).collect(Collectors.toList());
			}
		}

		if (enneagram != null) {
			if (EnneagramEnum.getEnum(enneagram) == null) {
				return ResponseHandler.response(MESSAGE_INVALID_ENNEAGRAM_FILTERING_VALUE, HttpStatus.BAD_REQUEST,
						null);
			} else {
				comments = comments.stream().filter(x -> enneagram.equals(x.getEnneagram()))
						.collect(Collectors.toList());
			}
		}

		if (zodiac != null) {
			if (ZodiacEnum.getEnum(zodiac) == null) {
				return ResponseHandler.response(MESSAGE_INVALID_ZODIAC_FILTERING_VALUE, HttpStatus.BAD_REQUEST, null);
			} else {
				comments = comments.stream().filter(x -> zodiac.equals(x.getZodiac())).collect(Collectors.toList());
			}
		}

		if (comments.isEmpty()) {
			return ResponseHandler.response(MESSAGE_NO_COMMENTS, HttpStatus.OK, null);
		} else {
			return ResponseHandler.response(MESSAGE_COMMENTS_FOUND, HttpStatus.OK, comments);
		}
	}

	@PatchMapping(path = "comments/{idComment}/like-dislike")
	public ResponseEntity<Object> likeDislikeComment(@PathVariable String idComment, @RequestBody Like like) {
		Comment comment = commentService.getCommentById(idComment);

		if (comment == null) {
			return ResponseHandler.response(MESSAGE_NO_COMMENT, HttpStatus.OK, null);
		}
		if (userService.getUserById(like.getIdUserCreator()) == null) {
			return ResponseHandler.response(MESSAGE_NO_USER, HttpStatus.OK, null);
		}

		Comment updatedComment = commentService.updateVote(comment, like);

		return ResponseHandler.response(MESSAGE_COMMENT_UPDATED, HttpStatus.OK, updatedComment);
	}

}
