package com.springboot.retail.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.retail.entity.Customer;
import com.springboot.retail.entity.constant.Role;
import com.springboot.retail.service.AccountCreationService;

@WebMvcTest(AccountCreationController.class)
public class AccountCreationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountCreationService accountCreationService;

	@MockBean
	private AccountCreationController accountCreationController;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void createAccountIntegTest() throws Exception {

		Customer customer = new Customer("Mansoor", Role.EMPLOYEE);
		String customerString = objectMapper.writeValueAsString(customer);

		String url = "/account/create";

		mockMvc.perform(MockMvcRequestBuilders.post(url).content(customerString).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

	}

	@Test
	public void createAccountTest() {
		Customer customer = new Customer("Manish", Role.BUYER);
		Mockito.when(accountCreationService.createAccount(Mockito.any(Customer.class))).thenReturn(customer);
		accountCreationService.createAccount(customer);
		verify(accountCreationService, times(1)).createAccount(customer);
	}

}
