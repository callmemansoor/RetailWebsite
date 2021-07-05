package com.springboot.retail.entity.constant;

public enum Role {
	
	
	BUYER(0) , EMPLOYEE(30) , AFFILIATE(10) ;
	
	private final double discount;

	private Role(double discount) {
		this.discount = discount;
	}

	public double getDiscount() {
		return discount;
	}

	
	
}
