package com.springboot.retail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.retail.dto.OrderRequest;
import com.springboot.retail.dto.OrderResponse;
import com.springboot.retail.service.OrderPlaceService;

@RestController
@RequestMapping("/order")
public class OrderPlaceController {

	@Autowired
	private OrderPlaceService orderPlaceService;

	@PostMapping("/placeorder")
	public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {

		OrderResponse orderResponse = orderPlaceService.placeOrder(orderRequest);

		return new ResponseEntity<String>(
				"Hi " + orderResponse.getCustomerName() + "Your Order Has Been SuccessFully Placed. "
						+ "And Your Total Payable Amount Is :" + orderResponse.getTotalBill(),
				HttpStatus.CREATED);
	}

}
