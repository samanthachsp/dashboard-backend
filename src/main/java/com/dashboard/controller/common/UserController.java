package com.dashboard.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.portal.User;
import com.dashboard.services.common.UserServiceImpl;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/v1.0/user")
	public ResponseEntity<List<User>> getUsers(@RequestParam String name) throws Exception {
		List<User> users = userService.getUsers(name);
//		List<User> updatedUsers  = users.stream().map(item-> {
//			item.setPassword(""); 
//			return item;
//		}).collect(Collectors.toList());
		return ResponseEntity.ok(users);
	}

	@GetMapping("/v1.0/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable(value ="id") String id) throws Exception {
		System.out.println("getUser - ");
		User user = userService.findUserById(id);
//		user.setPassword("");
		return ResponseEntity.ok(user);
	}

	
	
}
