package org.jsp.SpringBootUserCurd.controller;

import java.util.List;

import org.jsp.SpringBootUserCurd.dto.User;
import org.jsp.SpringBootUserCurd.repository.UserRepository;
import org.jsp.SpringBootUserCurd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




//@CrossOrigin
@CrossOrigin(origins = "*")

@RestController
public class UserController
{
	
	
	
	
	
	
	
	@Autowired
	UserRepository rep;
	
	@Autowired
	UserService service;
		
	
	// SAVE USER
	// http://localhost:8080/save
	@PostMapping("/save")
	public User saveUser(@RequestBody User user)
	{
		User user2 = service.saveUser(user);
		return user2;
	}
	
	
	// FIND USER BY ID
	// http://localhost:8080/find?id=1
	@GetMapping("/find")
	public User findUser(@RequestParam int id)
	{
		return service.findUserByIdd(id);
	}
	

	// UPDATE USER
	//PUT http://localhost:8080/update
	@PutMapping("/update")
	public User updateUser(@RequestBody User user)
	{
		return service.updateUser(user);
	}
				
	@DeleteMapping("/delete/{id}")
	//DELETE http://localhost:8080/delete/5
	//DELETE http://localhost:8080/delete?id=1
	public User deleteUserById(@PathVariable int id)
	{
		return service.deleteUserById(id);
	}
	
	
	// FIND ALL USERS
	// http://localhost:8080/findall
	@GetMapping("/findall")
	public List<User> findAllUser()
	{
		return service.findAll();
	}
		
		
	// LOGIN
	// http://localhost:8080/login/abc@gmail.com/1234
	@GetMapping("/login/{email}/{password}")
	public String login(@PathVariable String email, @PathVariable String password)
	{
		List<User> users = service.findAll();
		for(User user : users)
		   {
				if(user.getEmail().equals(email) && user.getPassword().equals(password))
				{
					return "Login Success";
				}
			}
			return "Invalid Email or Password";
		}
}		
////LOGIN
//	@GetMapping("/login/{email}/{password}")
//	public String login(@PathVariable String email,
//			            @PathVariable String password)
//	{
//		return service.login(email, password);
//	}
//}
		
		
			
		


/*
 //THIS IS CORRECT FOR SSERVICE
 
 package org.jsp.SpringBootUserCurd.controller;

import java.util.List;

import org.jsp.SpringBootUserCurd.dto.User;
import org.jsp.SpringBootUserCurd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
	@Autowired
	private UserService service;

	// SAVE USER
	@PostMapping("/save")
	public User saveUser(@RequestBody User user)
	{
		return service.saveUser(user);
	}

	// FIND USER BY ID
	@GetMapping("/find")
	public User findUser(@RequestParam int id)
	{
		return service.findUserById(id);
	}

	// UPDATE USER
	@PutMapping("/update")
	public User updateUser(@RequestBody User user)
	{
		return service.updateUser(user);
	}

	// DELETE USER
	@DeleteMapping("/delete/{id}")
	public User deleteUser(@PathVariable int id)
	{
		return service.deleteUserById(id);
	}

	// FIND ALL USERS
	@GetMapping("/findall")
	public List<User> findAllUsers()
	{
		return service.findAll();
	}

	// LOGIN
	@GetMapping("/login/{email}/{password}")
	public String login(@PathVariable String email,
			            @PathVariable String password)
	{
		return service.login(email, password);
	}
}
 */





/*
 //THIS FOR REP//
 package org.jsp.SpringBootUserCurd.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootUserCurd.dto.User;
import org.jsp.SpringBootUserCurd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{

    @Autowired
    UserRepository rep;

    // SAVE USER
    // http://localhost:8080/save
    @PostMapping("/save")
    public User saveUser(@RequestBody User user)
    {
        return rep.save(user);
    }

    // UPDATE USER
    // http://localhost:8080/update
    @PutMapping("/update")
    public User updateUser(@RequestBody User user)
    {
        return rep.save(user);
    }
    
    
    
 // FIND USER BY ID USING REQUEST PARAM
    // http://localhost:8080/find?id=1
    @GetMapping("/find")
    public Optional<User> findUserById(int id)
    {
        return rep.findById(id);
    }
    
    
// FIND USER BY ID
// 	@GetMapping("/find")
// 	public User findUser(@RequestParam int id)
// 	{
// 		return service.findUserById(id);
// 	}

   
    
    // FIND USER BY ID USING REQUEST PARAM
    // http://localhost:8080/find?id=1
    @GetMapping("/find")
    public User findUser1(@RequestParam int id)
    {
        Optional<User> optional = rep.findById(id);

        if(optional.isPresent())
        {
            return optional.get();
        }	
        else
        {
            return null;
        }
    }
	
    // LOGIN
    // http://localhost:8080/login/abc@gmail.com/1234
    @GetMapping("/login/{email}/{password}")
    public String login(@PathVariable String email,
                        @PathVariable String password)
    {
        List<User> users = rep.findAll();
 
        for(User user : users)
        {
            if(user.getEmail().equals(email)
                    && user.getPassword().equals(password))
            {
                return "Login Success";
            }
        }

        return "Invalid Email or Password";
    }

    // FIND ALL USERS
    // http://localhost:8080/findall
   @GetMapping("/findall")
    public List<User> findAllUser()
    {
        return rep.findAll();
    }
    

    // DELETE USER
    // http://localhost:8080/delete?id=1
    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam int id)
    {
        rep.deleteById(id);

        return "User Deleted Successfully";
    }
}
*/
/*
 //THIS FOR SERVOICE
 package org.jsp.SpringBootUserCurd.controller;

import java.util.List;

import org.jsp.SpringBootUserCurd.dto.User;
import org.jsp.SpringBootUserCurd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
	@Autowired
	private UserService service;

	// SAVE USER
	@PostMapping("/save")
	public User saveUser(@RequestBody User user)
	{
		return service.saveUser(user);
	}

	// UPDATE USER
	@PutMapping("/update")
	public User updateUser(@RequestBody User user)
	{
		return service.updateUser(user);
	}

	// FIND USER BY ID
	@GetMapping("/find")
	public User findUser(@RequestParam int id)
	{
		return service.findUserById(id);
	}

	// FIND ALL USERS
	@GetMapping("/findall")
	public List<User> findAllUsers()
	{
		return service.findAllUsers();
	}

	// DELETE USER
	@DeleteMapping("/delete")
	public String deleteUser(@RequestParam int id)
	{
		return service.deleteUser(id);
	}

	// LOGIN
	@GetMapping("/login/{email}/{password}")
	public String login(@PathVariable String email,
			            @PathVariable String password)
	{
		return service.login(email, password);
	}
}
 */

