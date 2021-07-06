package com.springboot.retail.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.retail.entity.Product;
import com.springboot.retail.entity.constant.ProductType;
import com.springboot.retail.repositoty.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void findByIdAndSaveTest() {
		Product product = new Product(1, "RICE", 100, ProductType.GROCERY);
		Product saveProd = productRepository.save(product);

		System.out.println("==========" + saveProd.getId() + "============");

		Product expProduct = productRepository.getById(saveProd.getId());

		assertThat(expProduct.getName()).isEqualTo(product.getName());
	}

}
