package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.EmployeeBean;
import com.service.EmployeeRepository;
import com.service.EmployeeServices;

@Repository
public class EmployeeDao implements EmployeeServices {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public int saveEmployee(EmployeeBean employeeBean) {

		int res=0;
		try {
			employeeRepository.save(employeeBean);
			res=1;
		}
		catch (Exception e) {

			res =-1;
		}
		return res;
	}

	@Override
	public List<EmployeeBean> findByTrue() {
		
		return employeeRepository.findByisActiveFalse();
	}

	@Override
	public List<EmployeeBean> findByeNameisStartsWith(String eName) {
		
		return employeeRepository.findByeNameContaining(eName);
	}

	@Override
	public List<EmployeeBean> findbyAGes(double sal) {
		
		return employeeRepository.findBySalaryGreaterThan(sal);
	}
	

}
