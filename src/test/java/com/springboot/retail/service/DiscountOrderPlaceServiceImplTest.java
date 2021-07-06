package com.springboot.retail.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.retail.dto.OrderRequest;
import com.springboot.retail.dto.OrderResponse;
import com.springboot.retail.entity.Customer;
import com.springboot.retail.entity.Order;
import com.springboot.retail.entity.Product;
import com.springboot.retail.entity.constant.ProductType;
import com.springboot.retail.entity.constant.Role;
import com.springboot.retail.repositoty.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class DiscountOrderPlaceServiceImplTest {

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	private DiscountOrderPlaceServiceImpl discountOrderPlaceService;

	@Test
	public void calculatePercentageDiscountTest() {
		double expectedValue = 190;
		double actualValue = discountOrderPlaceService.calculatePercentageDiscount(200, 5);
		assertThat(expectedValue).isEqualTo(actualValue);
	}

	@Test
	public void getOrderWithDiscountTest() {
		Product p1 = new Product("RICE", 100, ProductType.GROCERY);
		Product p2 = new Product("MANGO", 200, ProductType.FRUITS);
		Product p3 = new Product("MOBILE", 200, ProductType.ELECTRONIC);

		List<Product> products = new ArrayList<>();
		Collections.addAll(products, p1, p2, p3);

		Order order = new Order();
		order.setProducts(products);

		OrderRequest orderRequest = new OrderRequest(1, order);

		Customer customer = new Customer("Mansoor", Role.BUYER);
		customer.setRegisteredDate(LocalDate.now().minusYears(3));
		Order actualOrder = discountOrderPlaceService.getOrderWithDiscount(orderRequest, customer);
		assertThat(460d).isEqualTo(actualOrder.getOrderPrice());

		Customer customer2 = new Customer("Manish", Role.EMPLOYEE);
		customer.setRegisteredDate(LocalDate.now().minusYears(1));

		OrderRequest orderRequest2 = new OrderRequest(2, order);

		Order actualOrder2 = discountOrderPlaceService.getOrderWithDiscount(orderRequest2, customer2);

		assertThat(365d).isEqualTo(actualOrder2.getOrderPrice());

	}

	@Test
	public void placeOrderTest() {

		Product p1 = new Product("RICE", 100, ProductType.GROCERY);
		Product p2 = new Product("MANGO", 200, ProductType.FRUITS);
		Product p3 = new Product("MOBILE", 200, ProductType.ELECTRONIC);

		List<Product> products = new ArrayList<>();
		Collections.addAll(products, p1, p2, p3);

		Order order = new Order();
		order.setProducts(products);

		OrderRequest orderRequest = new OrderRequest(1, order);

		Customer customer = new Customer(1, "Mansoor", LocalDate.now().minusYears(3), Role.BUYER);
		Mockito.when(customerRepository.getById(1)).thenReturn(customer);

		OrderResponse orderResponse = discountOrderPlaceService.placeOrder(orderRequest);

		assertThat(460d).isEqualTo(orderResponse.getTotalBill());

	}

}
