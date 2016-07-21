package io.egen.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.app.entity.Employee;
import io.egen.app.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	@Qualifier("empService")
	private IEmployeeService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Employee> findAll () {
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Employee findOne(@PathVariable("id") String employeeId) {
		return service.findOne(employeeId);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Employee create (@RequestBody Employee emp) {
		return service.create(emp);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Employee update (@PathVariable("id") String employeeId, @RequestBody Employee emp) {
		return service.update(employeeId, emp);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void delete (@PathVariable("id") String employeeId) {
		service.delete(employeeId);
	}
}
