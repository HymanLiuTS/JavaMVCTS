package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Tweet;
import com.example.demo.error.EntityNotFoundException;

@RestController
@RequestMapping("/api")
public class UserRepositoryControllor {

	private UserRepository userRepository;

	@Autowired
	public UserRepositoryControllor(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<Tweet> create(@RequestBody Tweet tweet) {
		Tweet t = userRepository.save(tweet);
		ResponseEntity<Tweet> result = new ResponseEntity<Tweet>(t, HttpStatus.BAD_REQUEST);
		return result;
	}
	
	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public ResponseEntity<Tweet> findUser(@PathVariable String name) throws EntityNotFoundException {
		Tweet t = userRepository.findOne(name);
		ResponseEntity<Tweet> result = new ResponseEntity<Tweet>(t, HttpStatus.BAD_REQUEST);
		return result;
	}
}
