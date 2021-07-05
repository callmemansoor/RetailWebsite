package com.springboot.retail.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.retail.entity.Customer;
import com.springboot.retail.entity.constant.Role;
import com.springboot.retail.repositoty.CustomerRepository;

@RestController
@RequestMapping("/api")
public class OrderPlaceController {
	
	@Autowired
	private CustomerRepository customerRepo;

	@GetMapping("/placeorder")
	public ResponseEntity<String> handle() {
		Customer c = new Customer(1, "Mansoor", new Date(2021, 06, 01) , Role.AFFILIATE);
		customerRepo.save(c);

		return new ResponseEntity<String>("Order Placed", HttpStatus.CREATED);
	}

}
