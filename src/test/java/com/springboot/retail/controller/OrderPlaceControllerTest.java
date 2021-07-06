package com.springboot.retail.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.retail.dto.OrderRequest;
import com.springboot.retail.entity.Order;
import com.springboot.retail.entity.Product;
import com.springboot.retail.entity.constant.ProductType;

@WebMvcTest(OrderPlaceController.class)
public class OrderPlaceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderPlaceController orderPlaceController;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void placeOrderTest() throws Exception {
		Product p1 = new Product("RICE", 100, ProductType.GROCERY);
		Product p2 = new Product("MANGO", 200, ProductType.FRUITS);
		Product p3 = new Product("MOBILE", 50, ProductType.ELECTRONIC);

		List<Product> products = new ArrayList<>();
		Collections.addAll(products, p1, p2 , p3);

		Order order = new Order(1, 350, products);

		OrderRequest orderRequest = new OrderRequest(1, order);

		String orderRequestString = objectMapper.writeValueAsString(orderRequest);

		String url = "/order/placeorder";

		mockMvc.perform(MockMvcRequestBuilders.post(url).content(orderRequestString)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn();

	}

}
