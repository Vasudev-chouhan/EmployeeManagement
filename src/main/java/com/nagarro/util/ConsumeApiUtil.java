package com.nagarro.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.nagarro.model.Employee;

public class ConsumeApiUtil {

	public static Employee getEmployeeById(int id) {

		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

		ResponseEntity<Employee> responseEntity = restTemplate.exchange(ApiConstants.GET_SINGLE_EMPLOYEE + id,
				HttpMethod.GET, null, Employee.class);
		Employee employee = responseEntity.getBody();
		return employee;

	}

	public static List<Employee> getAllEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		ResponseEntity<Employee[]> response = restTemplate.exchange(ApiConstants.GET_ALL_EMPLOYEE, HttpMethod.GET, null,
				Employee[].class);
		Employee[] employees = response.getBody();
		System.out.println(Arrays.toString(employees));
		return Arrays.asList(employees);

	}

	public static void addEmployee(Employee employee) {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(employee);
		restTemplate.postForLocation(ApiConstants.ADD_EMPLOYEE, requestEntity);

	}

	public static void updateEmployee(Employee employee) {
		System.out.println(employee);
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(employee);
		restTemplate.put(ApiConstants.UPDATE_EMPLOYEE, requestEntity);

	}

	public static void deleteEmployee(int id) {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		restTemplate.delete(ApiConstants.DELETE_EMPLOYEE + id);

	}
	
	public static String changeDate(Date date) {
		String changedDate;
		DecimalFormat dayFormat = new DecimalFormat("00");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		changedDate = dayFormat.format(
				cal.get(Calendar.DATE)) + "/" 
				+ dayFormat.format((cal.get(Calendar.MONTH) + 1)) + "/" 
				+ cal.get(Calendar.YEAR);
		return changedDate;
	}

}
