package com.springboot.retail.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="user_id")
	private Integer userId;
	
	@OneToMany(fetch=FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<Product> products;
	
	public void addProduct(Product product) {
		if(products ==null) {
			products = new ArrayList<Product>();
		}
		
		products.add(product);
	}

}
