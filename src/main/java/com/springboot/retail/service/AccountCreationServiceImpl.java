package com.springboot.retail.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.retail.entity.Customer;
import com.springboot.retail.repositoty.CustomerRepository;

@Service
public class AccountCreationServiceImpl implements AccountCreationService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Customer createAccount(Customer customer) {
		customer.setRegisteredDate(LocalDate.now());
		return customerRepo.save(customer);
	}

}
