package com.boo.codingtest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boo.codingtest.comment.Comment;
import com.boo.codingtest.comment.service.CommentService;

@SpringBootTest
public class CommentControllerTest {

	@Autowired
	private CommentService commentService;

	@Test
	public void addComment() {
		Comment comment = new Comment();

		commentService.addComment(comment);

		assertNotNull(comment.getId());
	}
}
