package com.boo.codingtest.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boo.codingtest.user.User;
import com.boo.codingtest.user.repository.UserRepository;

@Service
public class UserService {

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(String idUser) {
		return userRepository.findById(idUser).orElse(null);
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

}
