package io.egen.app.service;

import java.util.List;

import io.egen.app.entity.Employee;

public interface IEmployeeService {

	public List<Employee> findAll();

	public Employee findOne(String id);

	public Employee create(Employee emp);

	public Employee update(String id, Employee emp);

	public void delete(String id);
}
