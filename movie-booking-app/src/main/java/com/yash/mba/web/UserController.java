package com.yash.mba.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.mba.domain.Movie;
import com.yash.mba.domain.User;
import com.yash.mba.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
//    @PostMapping("/check")
//     public boolean checkUserDetails(@RequestBody User user)  {
//
//    	List<User> users=userService.getAllUsers();
//    	List<User> uName=users.stream().filter(u -> u.getUserName().matches(user.getUserName())).toList();
//    	List<User> uPassword=users.stream().filter(u -> u.getPassword().matches(user.getPassword())).toList();
//
//    	if (uName.size() >= 1 && uPassword.size() >=1)
//    		return true;
//    	else
//    		return false;	
//    }
    
    @PostMapping("/check")
    public long checkUserDetails(@RequestBody User user) {

    List<User> users=userService.getAllUsers();
    List<User> uName=users.stream().filter(u -> u.getUserName().matches(user.getUserName())).limit(1).toList();
    List<User> uPassword=users.stream().filter(u -> u.getPassword().matches(user.getPassword())).limit(1).toList();

    if (uName.size() >= 1 && uPassword.size() >=1) {
    User userId=uPassword.get(0);
    return userId.getId();
    }
    else
    return 0;
    }
    
    @DeleteMapping("/users/{user_id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long user_id) {
		userService.deleteUserById(user_id);
		return ResponseEntity.noContent().build();
	}
    
    
    
}
