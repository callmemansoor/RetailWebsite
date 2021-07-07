package com.springboot.retail.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.retail.entity.Customer;
import com.springboot.retail.exception.AccCreationEmptyInputException;
import com.springboot.retail.repositoty.CustomerRepository;

@Service
public class AccountCreationServiceImpl implements AccountCreationService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer createAccount(Customer customer) {
		if (customer.getName() == null || customer.getRole() == null) {
			throw new AccCreationEmptyInputException("601", "name or role cannot be empty");
		}
		customer.setRegisteredDate(LocalDate.now());
		return customerRepo.save(customer);
	}

}
