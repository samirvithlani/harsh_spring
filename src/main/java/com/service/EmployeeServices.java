package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bean.EmployeeBean;

@Service
public interface EmployeeServices {

	public int saveEmployee(EmployeeBean employeeBean);
	public List<EmployeeBean> findByTrue();
	public List<EmployeeBean> findByeNameisStartsWith(String eName);
	public List<EmployeeBean> findbyAGes(double eSalary);
	public List<EmployeeBean> getAllEmployee();
	
}
