package com.boo.codingtest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boo.codingtest.user.User;
import com.boo.codingtest.user.service.UserService;

@SpringBootTest
public class UserControllerTest {

	@Autowired
	private UserService userService;

	User userTest;

	@Test
	public void getAllUsers() {
		List<User> users = userService.getAllUsers();
		assertNotNull(users);
	}

	@Test
	public void getUserById() {
		assertNotNull(userService.getUserById(userTest.getId()));
	}

	@BeforeEach
	public void before() {
		userTest = new User();
		userTest.setName("User test");
		userTest = userService.addUser(userTest);
	}

	@AfterEach
	public void after() {

		userService.deleteUser(userTest);
		userTest = null;
	}
}
