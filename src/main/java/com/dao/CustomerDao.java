package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Customer;
import com.service.CosutomerService;
import com.service.CustomerRepository;

@Repository
public class CustomerDao implements CosutomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Override
	public int addAllCustomer(List<Customer> customers) {
	
		int res =0;
		try {
		customerRepository.saveAll(customers);
		res=1;
		}
		catch (Exception e) {
			
			res =-1;
		}
		return res;
		
	}

	
	
	
}
