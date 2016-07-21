package io.egen.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.app.entity.User;
import io.egen.app.service.IUserService;

@RestController
@CrossOrigin(origins="http://localhost:63342")
@RequestMapping("/users")
public class UserController {

	@Autowired
	@Qualifier("usService")
	private IUserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> findAll () {
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public User findOne(@PathVariable("id") String userId) {
		return service.findOne(userId);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public User create (@RequestBody User us) {
		return service.create(us);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public User update (@PathVariable("id") String userId, @RequestBody User us) {
		return service.update(userId, us);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void delete (@PathVariable("id") String userId) {
		service.delete(userId);
	}
}
