package com.nagarro.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.Employee;
import com.nagarro.service.EmployeeService;

@Controller
public class EmployeeController {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Bean.xml");
	private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");	

	@Autowired
	private EmployeeService employeeService;	
	
	@RequestMapping(value = "/updateEmployee")
	public ModelAndView updateDetails(HttpServletRequest request, HttpServletResponse response) {		
		int empcode = Integer.parseInt(request.getParameter("employeeCode"));
		String empname = request.getParameter("employeeName");

		String email = request.getParameter("email");
		Date date = null;
		try {
			date = dateFormat.parse(request.getParameter("date"));
		} catch (ParseException e) {

			System.out.println("parsing error" + e);
		}

		String location = request.getParameter("location");	
		Employee employee = applicationContext.getBean("employee", Employee.class);
		employee.setEmployeeCode(empcode);
		employee.setEmail(email);
		employee.setDateOfBirth(date);
		employee.setEmployeeName(empname);
		employee.setLocation(location);
		employeeService.updateEmployee(employee);
		ModelAndView mv = new ModelAndView();
		List<Employee> employeeList = employeeService.getAllEmployee();
		mv.addObject("employeeList", employeeList);
		mv.setViewName("home.jsp");
		return mv;

	}
	
}
