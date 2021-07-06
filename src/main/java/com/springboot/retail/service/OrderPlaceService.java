package com.springboot.retail.service;

import com.springboot.retail.dto.OrderRequest;
import com.springboot.retail.dto.OrderResponse;

public interface OrderPlaceService {

	OrderResponse placeOrder(OrderRequest orderRequest);

}
