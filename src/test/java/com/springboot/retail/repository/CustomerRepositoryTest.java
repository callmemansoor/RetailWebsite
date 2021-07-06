package com.springboot.retail.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.retail.entity.Customer;
import com.springboot.retail.entity.constant.Role;
import com.springboot.retail.repositoty.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

	
	@Autowired
	private CustomerRepository customerRepository ;
	
	@Test
	public void findByIdAndSaveTest() {
		Customer customer = new Customer("Mansoor" , Role.AFFILIATE);
		customer.setId(1);
		Customer savedCustomer =customerRepository.save(customer);
		
		Customer newCust = customerRepository.getById(savedCustomer.getId());

		assertThat(newCust.getName())
	      .isEqualTo(customer.getName());
	}
}
