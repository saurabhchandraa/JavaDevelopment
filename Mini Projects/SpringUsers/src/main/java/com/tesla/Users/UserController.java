package com.tesla.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(path="/all")
	public String getAllUsers(Model model) {
		
		List<User> UserList = userService.getAllUsers();		
		model.addAttribute("UserList",UserList);		
		return "displayThyme";
	}
	
	@GetMapping("/add")
	public String add(Model model)
	{
		model.addAttribute("UserList", new User());
		return "new";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("UserList") User UserList) {		
	userService.saveUser(UserList);
	return "redirect:/all";	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/update/{id}")
	public ModelAndView updateUserById(@PathVariable(name = "id") int id)
	{
		ModelAndView mv = new ModelAndView("new");
		User u = userService.find(id);
		mv.addObject("UserList", u);
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/delete/{id}")
	public String deleteUserById(@PathVariable(name = "id") int id)
	{
		userService.delete(id);
		return "redirect:/all";
	}
	

}
