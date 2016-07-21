package io.egen.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.User;
import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.IUserRepository;

@Service("usService")
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repository;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		User us = repository.findOne(id);
		if(us == null) {
			throw new EntityNotFoundException("User with id " + id + " doesn't exist");
		}
		return us;
	}

	@Override
	public User create(User us) {
		return repository.create(us);
	}

	@Override
	public User update(String id, User us) {
		User existing = repository.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException("User with id " + id + " doesn't exist");
		}
		return repository.update(us);
	}

	@Override
	public void delete(String id) {
		User existing = repository.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException("User with id " + id + " doesn't exist");
		}
		repository.delete(existing);
	}

}
