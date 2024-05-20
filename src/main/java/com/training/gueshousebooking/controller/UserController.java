package com.training.gueshousebooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.gueshousebooking.daos.LoginDao;
import com.training.gueshousebooking.models.User;
import com.training.gueshousebooking.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository userRepo;

	//get username by username and password
	@PostMapping
	public ResponseEntity<User> loginUser(@RequestBody LoginDao loginDao) {
		User user = userRepo.findByNameAndPassword(loginDao.getUserName(), loginDao.getPassword());
		 return ResponseEntity.ok(user);

	}

	//get list of users
	@GetMapping
	public Iterable<User> getUsers() {
		return userRepo.findAll();
	}
}
