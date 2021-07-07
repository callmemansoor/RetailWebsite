package com.springboot.retail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.retail.entity.Customer;
import com.springboot.retail.service.AccountCreationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/account")
public class AccountCreationController {

	private static final String VALUE = "{ \"name\":\"Mansoor\", \"role\":\"BUYER\" }";

	@Autowired
	private AccountCreationService accountCreationService;

	@ApiOperation(value = "Create a User", response = String.class)
	@PostMapping("/create")
	public ResponseEntity<String> createAccount(
			@ApiParam(name = "Enter name and User role", value = VALUE) @RequestBody Customer customer) {

		Customer savedCustomer = accountCreationService.createAccount(customer);
		return new ResponseEntity<String>("Hurray!! " + "Thank you for Signing Up : " + savedCustomer.getName()
				+ " Your Officially A Member Of Our Retail Website. Your Customer Id Is : " + savedCustomer.getId(),
				HttpStatus.CREATED);
	}

}
