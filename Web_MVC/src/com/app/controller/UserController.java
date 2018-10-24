package com.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.User;
import com.app.serviceI.ServiceI;

@Controller
public class UserController {
@Autowired
ServiceI si;


@RequestMapping("/")
public String login()
{
	System.out.println("In login");
	return "Login";
	
}



@RequestMapping("/registerpage")
public String register()
{
	System.out.println("In register");
	return "Register";
	

}

@RequestMapping("/reg")
public String saveUser(@ModelAttribute User u,Model model){
	System.out.println(u.getName());
	String msg="Your data is Saved Successully !";
	int id=si.saveUser(u);
	System.out.println(id);
	if(id>0){
		model.addAttribute("msg",msg);
		return "Login";
	}
	else{
		return "Register";
	}
}

@RequestMapping("/log")
public ModelAndView loginUser(String uname,String pass){
	System.out.println("In loginUser");
	List<User> ul=si.loginUser( uname, pass);
	System.out.println(ul);
	if(!ul.isEmpty()){
		return new ModelAndView("Success","udata",ul);
	}
	else{
		String msg="Wrong usernsme or password----!";
	return new ModelAndView("Login","msg",msg);
	}
}
	

@RequestMapping("/del")
public ModelAndView deleteUser(int id){
	System.out.println("in deleteUser");
	List<User> ul=si.deleteUser(id);
	if(!ul.isEmpty()){
		return new ModelAndView("Success","udata",ul);
	}
	else{
		String msg="record is not deleted---!";
	return new ModelAndView("Success","msg",msg);
	
	}
}




@RequestMapping("/edit")
public ModelAndView editUser(int id){
	System.out.println("in deleteUser");
	User u=si.editData(id);
	
	return new ModelAndView("Edit","udata",u);
	
}
@RequestMapping("/update")
public ModelAndView updateUser(@ModelAttribute User u){
	System.out.println("in updateUser");
	List<User> ul=si.updatedata(u);
	if(!ul.isEmpty()){
		return new ModelAndView("Success","udata",ul);
	}
	else{
		String msg="record not Updated---!";
		return new ModelAndView("Login","msg",msg);
	}
}
}




