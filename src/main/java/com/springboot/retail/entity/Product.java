package com.springboot.retail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springboot.retail.entity.constant.ProductType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String name;
	
	private int price;

	@Enumerated(EnumType.STRING)
	@Column(name="product_type")
	private ProductType productType;

	public Product(String name, int price, ProductType productType) {
		super();
		this.name = name;
		this.price = price;
		this.productType = productType;
	}
	
	

}
