package com.tesla.Users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class UserController {
	
	@Autowired
	private UserRepository userRep;
	
	
	@GetMapping(path="/all")
	public String getAllUsers(Model model) {
		
		List<User> UserList = (List<User>) userRep.findAll();
		model.addAttribute("UserList",UserList);
		//return (List<User>) userRep.findAll();		
		 return "displayThyme";
	}
	
	@PostMapping("/add")
	public void addUser(@ModelAttribute("newUser") User newUser) {
//	    User u = new User();
//	    u.setName(name);
//	    u.setEmail(email);
		userRep.save(newUser);
		
	}

}
