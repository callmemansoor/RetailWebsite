package com.springboot.retail.entity.constant;

public enum Role {
	
	
	BUYER(0) , EMPLOYEE(30) , AFFILIATE(10) ;
	
	private final int discount;

	private Role(int discount) {
		this.discount = discount;
	}

	public int getDiscount() {
		return discount;
	}

	
	
}
