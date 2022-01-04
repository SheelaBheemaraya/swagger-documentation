package com.swapper.api.swaggerdocumentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swapper.api.swaggerdocumentation.model.User;
import com.swapper.api.swaggerdocumentation.sevice.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userservice;
	
	@GetMapping("/user")
	public List<User> getUsers()
	{
		return userservice.getAllUsers();
		
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") int id)

	{
		return userservice.getUserById(id);
		
	}
	
	

	
	@PostMapping("/user")
    public User addUser(@RequestBody User user)
    {
		User b=this.userservice.addUser(user);
		return b;
    }
	// delete book handler

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
       
              this.userservice.deleteUser(userId);
			
    }
 // update book handler
    @PutMapping("/users/{Id}")
    public User updateUser(@RequestBody User user, @PathVariable("userId") int userId) {
		this.userservice.updateUser(user, userId);
		return user;

}

}
