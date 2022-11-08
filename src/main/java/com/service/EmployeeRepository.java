package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bean.EmployeeBean;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeBean, Integer> {

	
	List<EmployeeBean> findByisActiveFalse();
	List<EmployeeBean> findByeNameStartsWith(String eName);
	List<EmployeeBean> findByeNameContaining(String eName);
	List<EmployeeBean> findBySalaryGreaterThan(double eSalary);
	List<EmployeeBean> findByisActiveAndSalaryGreaterThan(boolean flag,double salary);
	
	//JPQL //HQL
	@Query("SELECT e FROM EmployeeBean e where e.eAge>=22")
	List<EmployeeBean> findAllEmployee();
	
	@Query(value = "Select * from employee",nativeQuery = true)
	List<EmployeeBean> findAllEmployeeByNative();
}
