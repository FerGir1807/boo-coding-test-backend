package com.boo.codingtest.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boo.codingtest.httpresponse.ResponseHandler;
import com.boo.codingtest.user.User;
import com.boo.codingtest.user.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private static final String MESSAGE_NO_USER = "No user found.";
	private static final String MESSAGE_NO_USERS = "No users found.";
	private static final String MESSAGE_USER_FOUND = "Users found.";
	private static final String MESSAGE_USER_CREATED = "User created successfully.";
	private static final String MESSAGE_INFORMATION_SUCCESSFUL = "Information retrieved successfully.";

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping(path = "/users")
	public ResponseEntity<Object> getUsers() {
		List<User> users = userService.getAllUsers();

		if (users.size() == 0) {
			return ResponseHandler.response(MESSAGE_NO_USERS, HttpStatus.OK, null);
		} else {
			return ResponseHandler.response(MESSAGE_INFORMATION_SUCCESSFUL, HttpStatus.OK, users);
		}

	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user, BindingResult result) {

		if (result.hasErrors()) {
			return ResponseHandler.response(result.getAllErrors().toString(), HttpStatus.BAD_REQUEST, null);

		} else {
			User newUser = userService.addUser(user);
			return ResponseHandler.response(MESSAGE_USER_CREATED, HttpStatus.CREATED, newUser);
		}

	}

	@GetMapping(path = "/users/{idUser}")
	public ResponseEntity<Object> getUserById(@PathVariable String idUser) {

		User user = userService.getUserById(idUser);
		if (user != null) {
			return ResponseHandler.response(MESSAGE_USER_FOUND, HttpStatus.OK, user);
		} else {
			return ResponseHandler.response(MESSAGE_NO_USER, HttpStatus.OK, user);
		}

	}

}
