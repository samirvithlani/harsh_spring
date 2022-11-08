package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bean.Customer;

@Service
public interface CosutomerService {

	public int addAllCustomer(List<Customer> customers);
}
