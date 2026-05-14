package org.jsp.SpringBootUserCurd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootUserCurdApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootUserCurdApplication.class, args);
	}
}





/*
Client/Postman
↓
Controller
↓
Service
↓
DAO
↓
Repository
↓
Database(MySQL)


UserController
    ↓
UserService
    ↓
UserDao
    ↓
UserRepository
    ↓
MySQL Database
*/