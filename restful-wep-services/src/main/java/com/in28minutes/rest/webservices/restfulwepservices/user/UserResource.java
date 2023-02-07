package com.in28minutes.rest.webservices.restfulwepservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	/*
	 * Response Status
	 * Resource not found > 404
	 * Server exception > 500
	 * Validation error > 400
	 * 
	 * 200 - Success
	 * 201 - Created
	 * 404 - No content
	 * 401 - Unauthorized (when authorization fails)
	 * 400 - Bad Request (such as validation error)
	 * 404 - Resource Not Found
	 * 500 - Server Error
	 */
	
	// GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	// GET /users/{id}
	@GetMapping("/users/{id}")
	public User retreiveUserWithId(@PathVariable int id) {
		User user = service.findOne(id);
		
		if (user == null)
			throw new UserNotFoundException("id: " + id);
		
		return user;
	}
	
	// DELETE /users/{id}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
	
	// POST /users
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		// /users/4 => /users /{id}. user.getID
		
		// from the current request url, append /id
		// replace id with the id of user we just made
		// return that user back through location key in header
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
