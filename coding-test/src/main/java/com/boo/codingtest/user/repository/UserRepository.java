package com.boo.codingtest.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boo.codingtest.user.User;

public interface UserRepository extends MongoRepository<User, String> {

}
