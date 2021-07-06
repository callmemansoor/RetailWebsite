package com.springboot.retail.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.retail.entity.Order;
import com.springboot.retail.entity.Product;
import com.springboot.retail.entity.constant.ProductType;
import com.springboot.retail.repositoty.OrderRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {

	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void findByIdAndSaveTest() {
		Product p1 = new Product("RICE", 100, ProductType.GROCERY);
		Product p2 = new Product("MANGO", 200, ProductType.FRUITS);
		Product p3 = new Product("MOBILE", 50, ProductType.ELECTRONIC);

		List<Product> products = new ArrayList<>();
		Collections.addAll(products, p1, p2, p3);

		Order order = new Order(1, LocalDate.now(), 350, products);
		Order saveOrder = orderRepository.save(order);

		Order expOrder = orderRepository.getById(saveOrder.getId());
		assertThat(expOrder.getOrderPrice()).isEqualTo(order.getOrderPrice());
	}

}
