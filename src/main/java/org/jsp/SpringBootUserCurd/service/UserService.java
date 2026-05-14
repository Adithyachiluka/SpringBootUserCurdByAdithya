package org.jsp.SpringBootUserCurd.service;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootUserCurd.exceptions.UserAlredayExistExcaption;
import org.jsp.SpringBootUserCurd.exceptions.UserNotFoundException;
import org.jsp.SpringBootUserCurd.dao.UserDao;
import org.jsp.SpringBootUserCurd.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService 
{
	
	@Autowired
	private UserDao dao;
	public User findUserByIdd(int id)
	{
		Optional<User> user = dao.findUserById(id);
		if(user.isPresent())
		{
			return user.get();
		}
		throw new UserNotFoundException("No user found with id " +id);
	}
	
	public User saveUser(User user) 
	{
		// TODO Auto-generated method stub
		Optional<User> user2 = dao.findUserById(user.getId());
		if(user2.isPresent())
		{
			throw new UserAlredayExistExcaption("No user found with id " +user.getId());
		}
		return dao.saveUser(user);

	}
	
	public User updateUser(User user) 
	{
		Optional<User> user2 = dao.findUserById(user.getId());
		if(user2.isPresent())
		{
			return dao.updateUser(user);
		}
		throw new UserNotFoundException("No user found with id " +user.getId());
		// TODO Auto-generated method stub
		//return null;
	}

	public User deleteUserById(int id) 
	{
		// TODO Auto-generated method stub
		Optional<User> user = dao.findUserById(id);
		
		if(user.isPresent())
		{
			User user2=user.get();
			dao.deleteUserById(id);
			return user2;
		}
		
		throw new UserNotFoundException("No user found with id " +user);
	}
	
	

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}


/*
 package org.jsp.SpringBootUserCurd.service;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootUserCurd.dao.UserDao;
import org.jsp.SpringBootUserCurd.dto.User;
import org.jsp.SpringBootUserCurd.exceptions.InvalidCredentialsException;
import org.jsp.SpringBootUserCurd.exceptions.UserAlreadyExistException;
import org.jsp.SpringBootUserCurd.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	@Autowired
	private UserDao dao;

	public User saveUser(User user)
	{
		Optional<User> optional = dao.findUserById(user.getId());

		if(optional.isPresent())
		{
			throw new UserAlreadyExistException("User Already Exists");
		}

		return dao.saveUser(user);
	}

	public User findUserById(int id)
	{
		Optional<User> optional = dao.findUserById(id);

		if(optional.isPresent())
		{
			return optional.get();
		}

		throw new UserNotFoundException("User Not Found");
	}

	public User updateUser(User user)
	{
		Optional<User> optional = dao.findUserById(user.getId());

		if(optional.isPresent())
		{
			return dao.updateUser(user);
		}

		throw new UserNotFoundException("Cannot Update, User Not Found");
	}

	public User deleteUserById(int id)
	{
		Optional<User> optional = dao.findUserById(id);

		if(optional.isPresent())
		{
			User user = optional.get();
			dao.deleteUserById(id);
			return user;
		}

		throw new UserNotFoundException("Cannot Delete, User Not Found");
	}

	public List<User> findAll()
	{
		return dao.findAll();
	}

	public String login(String email, String password)
	{
		List<User> users = dao.findAll();

		for(User user : users)
		{
			if(user.getEmail().equals(email)
					&& user.getPassword().equals(password))
			{
				return "Login Success";
			}
		}

		throw new InvalidCredentialsException("Invalid Email or Password");
	}
}
 */



