package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.Employee;
import com.nagarro.service.EmployeeService;
import com.nagarro.service.UserService;

@Controller
public class UserController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		List<Employee> employeeList = employeeService.getAllEmployee();
		modelAndView.addObject("employeeList", employeeList);
		modelAndView.setViewName("home.jsp");
		return modelAndView;
	}

	@RequestMapping(value = "/logOut")
	public ModelAndView logOut(HttpServletRequest request) {	
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("index.jsp");
	}
	
	@RequestMapping(value = "/authUser")
	public ModelAndView authUser(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		ModelAndView modelAndView = new ModelAndView();
		if (userService.authenticateUser(userName, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			List<Employee> employeeList = employeeService.getAllEmployee();
			modelAndView.addObject("employeeList", employeeList);
			modelAndView.setViewName("home.jsp");
			return modelAndView;
		} else
			return new ModelAndView("index.jsp?login=unsuccess");
	}
	
	

}
