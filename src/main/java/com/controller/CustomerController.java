package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Customer;
import com.dao.CustomerDao;

@RestController

public class CustomerController {

	@Autowired
	CustomerDao customerDao;

	@PostMapping(value = "/addcustomers")
	public ResponseEntity<?> addAllCustomers(@RequestBody List<Customer> customers) {

		int res = customerDao.addAllCustomer(customers);
		if (res > 0) {

			return new ResponseEntity<Object>("added", HttpStatus.OK);
		}

		return new ResponseEntity<Object>(null, HttpStatus.EXPECTATION_FAILED);

	}
}
