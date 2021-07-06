package com.springboot.retail.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.springboot.retail.entity.constant.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;

	@Column(name = "reg_date")
	private LocalDate registeredDate;

	@Enumerated(EnumType.STRING)
	@Column
	private Role role;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<Order> orders;

	public Customer(Integer id, String name, LocalDate date, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.registeredDate = date;
		this.role = role;
	}

	public Customer(String name, Role role) {
		super();
		this.name = name;
		this.role = role;
	}

	public void addOrder(Order order) {
		if (orders == null) {
			orders = new ArrayList<Order>();
		}
		orders.add(order);
	}

}
