package com.boo.codingtest.comment.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.boo.codingtest.comment.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

	List<Comment> findAllByIdUserDestination(String idUserDestination);

}
