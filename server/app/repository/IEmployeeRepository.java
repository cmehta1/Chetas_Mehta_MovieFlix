package io.egen.app.repository;

import java.util.List;

import io.egen.app.entity.Employee;

public interface IEmployeeRepository {

	public List<Employee> findAll();
	
	public Employee findOne(String id);
	
	public Employee create (Employee emp);
	
	public Employee update (Employee emp);
	
	public void delete (Employee emp);
}
