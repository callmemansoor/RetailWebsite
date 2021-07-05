package com.springboot.retail.dto;

import com.springboot.retail.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderPlace {

	private Integer userId;

	private Order order;

}
