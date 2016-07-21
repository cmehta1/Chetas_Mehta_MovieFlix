package io.egen.app.repository;

import java.util.List;

import io.egen.app.entity.User;

public interface IUserRepository {

	public List<User> findAll();
	
	public User findOne(String id);
	
	public User create (User us);
	
	public User update (User us);
	
	public void delete (User us);
}
