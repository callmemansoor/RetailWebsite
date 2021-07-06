package com.springboot.retail.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.retail.entity.Customer;
import com.springboot.retail.entity.constant.Role;
import com.springboot.retail.repositoty.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class AccountCreationServiceTest {

	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	private AccountCreationServiceImpl accountCreationService ;
	
	@Test
	void createAccountTest() {
		Customer customer = new Customer("Mansoor" , Role.AFFILIATE);
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		Customer savedCustomer = accountCreationService.createAccount(customer);
		assertThat(customer.getName())
	      .isEqualTo(savedCustomer.getName());
	}
	
	@Test
	void createAccountCallTest() {
		Customer customer = new Customer("Mansoor" , Role.AFFILIATE);
		accountCreationService.createAccount(customer);
		verify(customerRepository , times(1)).save(customer);
	}
	
}
