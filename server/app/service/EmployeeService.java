package io.egen.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.Employee;
import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.IEmployeeRepository;

@Service("empService")
@Transactional
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepository repository;
	
	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public Employee findOne(String id) {
		Employee emp = repository.findOne(id);
		if(emp == null) {
			throw new EntityNotFoundException("Employee with id " + id + " doesn't exist");
		}
		return emp;
	}

	@Override
	public Employee create(Employee emp) {
		return repository.create(emp);
	}

	@Override
	public Employee update(String id, Employee emp) {
		Employee existing = repository.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException("Employee with id " + id + " doesn't exist");
		}
		return repository.update(emp);
	}

	@Override
	public void delete(String id) {
		Employee existing = repository.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException("Employee with id " + id + " doesn't exist");
		}
		repository.delete(existing);
	}

}
