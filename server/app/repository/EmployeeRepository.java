package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.app.entity.Employee;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = em.createQuery("SELECT emp FROM Employee emp ORDER BY emp.email ASC", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findOne(String id) {
		return em.find(Employee.class, id);
	}

	@Override
	public Employee create(Employee emp) {
		em.persist(emp);
		return emp;
	}

	@Override
	public Employee update(Employee emp) {
		return em.merge(emp);
	}

	@Override
	public void delete(Employee emp) {
		em.remove(emp);
	}

}
