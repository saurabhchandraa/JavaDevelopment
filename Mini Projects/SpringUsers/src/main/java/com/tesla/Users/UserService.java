package com.tesla.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRep;
	
	public List<User> getAllUsers() {
		
		return (List<User>) userRep.findAll();
	}
		
	
	public void saveUser(User user) {	
	userRep.save(user);
	}
	
	public User find(int id)
	{
		return userRep.findById(id).get();
	}
	
	
	public ModelAndView updateUserById(@PathVariable(name = "id") int id)
	{
		ModelAndView mv = new ModelAndView("new");
		User u = userRep.findById(id).get();
		mv.addObject("UserList", u);
		return mv;
	}
	
	
	public void delete(int id)
	{
		userRep.deleteById(id);
	}

}
