package org.jsp.SpringBootUserCurd.exceptions;

public class InvalidCredentialsException extends RuntimeException
{
	public InvalidCredentialsException(String message)
	{
		super(message);
	}
}