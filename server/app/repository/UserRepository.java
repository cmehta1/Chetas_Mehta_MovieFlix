package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.app.entity.User;

@Repository
public class UserRepository implements IUserRepository {

	@PersistenceContext
	private EntityManager use;
	
	@Override
	public List<User> findAll() {
		TypedQuery<User> query = use.createQuery("SELECT us FROM User us", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String id) {
		return use.find(User.class, id);
	}

	@Override
	public User create(User us) {
		use.persist(us);
		return us;
	}

	@Override
	public User update(User us) {
		return use.merge(us);
	}

	@Override
	public void delete(User us) {
		use.remove(us);
	}

}
