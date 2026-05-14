package org.jsp.SpringBootUserCurd.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootUserCurd.dto.User;
import org.jsp.SpringBootUserCurd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao 
{
	@Autowired
	private UserRepository repository;
	
	public Optional<User> findUserById(int id)
	{
		return repository.findById(id);
	}

	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public User updateUser(User user)
	{
		return repository.save(user);
	}

	public void deleteUserById(int id) 
	{
		repository.deleteById(id);	
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	

	
}
	







