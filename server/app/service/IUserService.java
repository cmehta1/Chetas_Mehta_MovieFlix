package io.egen.app.service;

import java.util.List;

import io.egen.app.entity.User;

public interface IUserService {

	public List<User> findAll();

	public User findOne(String id);

	public User create(User us);

	public User update(String id, User us);

	public void delete(String id);
}
