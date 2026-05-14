package org.jsp.SpringBootUserCurd.exceptions;

public class UserNotFoundException extends RuntimeException
{

	public UserNotFoundException(String message)
	{
		super(message);
		
	}
	
}
