package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.EmployeeBean;
import com.dao.EmployeeDao;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;

	@PostMapping(value = "/addemp")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeBean employeeBean) {

		System.out.println(employeeBean.isActive());
		int res = employeeDao.saveEmployee(employeeBean);
		if (res > 0) {

			return new ResponseEntity<Object>("saved", HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>("failed", HttpStatus.EXPECTATION_FAILED);

	}
	@GetMapping(value = "/getemptrue")
	public ResponseEntity<?> getEmptrue(){
		
		//List<EmployeeBean> employees = employeeDao.findByeNameisStartsWith("sa");
		List<EmployeeBean> employees = employeeDao.findbyAGes(7852452.25);
		if(employees.size()>0) {
			
			return new ResponseEntity<Object>(employees, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(null, HttpStatus.EXPECTATION_FAILED);
		
		
	}
	
}
