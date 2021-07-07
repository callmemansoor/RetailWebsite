package com.springboot.retail.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.retail.dto.OrderRequest;
import com.springboot.retail.dto.OrderResponse;
import com.springboot.retail.entity.Customer;
import com.springboot.retail.entity.Order;
import com.springboot.retail.entity.Product;
import com.springboot.retail.entity.constant.ProductType;
import com.springboot.retail.repositoty.CustomerRepository;

@Service
public class DiscountOrderPlaceServiceImpl implements OrderPlaceService {

	private final static int fixedDiscountInDollars = 5;

	private final static int twoYearDiscountInPercentage = 5;

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public OrderResponse placeOrder(OrderRequest orderRequest) {
		Customer customer = customerRepo.getById(orderRequest.getCustomerId());
		Order order = getOrderWithDiscount(orderRequest, customer);
		customer.addOrder(order);
		customerRepo.save(customer);
		OrderResponse orderResponse = new OrderResponse(customer.getId(), customer.getName(), order.getOrderPrice());
		return orderResponse;
	}

	protected Order getOrderWithDiscount(OrderRequest orderRequest, Customer customer) {
		Order order = orderRequest.getOrder();
		order.setOrderDate(LocalDate.now());

		double totalBillAfterDiscount = 0;
		double billBeforeDollarDiscount = 0;

		for (Product product : order.getProducts()) {

			if (!product.getProductType().equals(ProductType.GROCERY)) {
				int custDiscount = customer.getRole().getDiscount();
				if (custDiscount != 0) {
					billBeforeDollarDiscount += calculatePercentageDiscount(product.getPrice(), custDiscount);
				} else if (customer.getRegisteredDate().isBefore(order.getOrderDate().minusYears(2))) {
					billBeforeDollarDiscount += calculatePercentageDiscount(product.getPrice(),
							twoYearDiscountInPercentage);
				} else {
					billBeforeDollarDiscount += product.getPrice();
				}
			} else {
				billBeforeDollarDiscount += product.getPrice();
			}
		}

		if (billBeforeDollarDiscount >= 100) {
			double discountMultiplier = Math.floor(billBeforeDollarDiscount / 100);
			totalBillAfterDiscount = billBeforeDollarDiscount - (fixedDiscountInDollars * discountMultiplier);
		}

		order.setOrderPrice(totalBillAfterDiscount);

		return order;
	}

	protected double calculatePercentageDiscount(int price, int discount) {

		return (price) - (price * discount / 100);
	}

}
