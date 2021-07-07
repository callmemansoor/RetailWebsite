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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/order")
public class OrderPlaceController {
	
	private final static String VALUE="{\r\n" + 
			"   \"customerId\":1,\r\n" + 
			"   \"order\":\r\n" + 
			"      {\r\n" + 
			"         \"products\":[\r\n" + 
			"            {\r\n" + 
			"               \"name\":\"Rice\",\r\n" + 
			"               \"price\":100,\r\n" + 
			"               \"productType\":\"GROCERY\"\r\n" + 
			"            },\r\n" + 
			"            {\r\n" + 
			"               \"name\":\"Apple\",\r\n" + 
			"               \"price\":200,\r\n" + 
			"               \"productType\":\"FRUITS\"\r\n" + 
			"            }\r\n" + 
			"         ]\r\n" + 
			"      }\r\n" + 
			"}\r\n" + 
			"";

	@Autowired
	private OrderPlaceService orderPlaceService;

	@ApiOperation(value = "Place a order",response = String.class)
	@PostMapping("/placeorder")
	public ResponseEntity<String> placeOrder(@ApiParam(name="Order Request", value=VALUE)@RequestBody OrderRequest orderRequest) {

		OrderResponse orderResponse = orderPlaceService.placeOrder(orderRequest);

		return new ResponseEntity<String>(
				"Hi " + orderResponse.getCustomerName() + " Your Order Has Been SuccessFully Placed. "
						+ "And Your Total Payable Amount Is :" + orderResponse.getTotalBill(),
				HttpStatus.CREATED);
	}

}
