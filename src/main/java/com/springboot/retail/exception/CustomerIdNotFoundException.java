package com.springboot.retail.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerIdNotFoundException extends RuntimeException{

	private String errCode;
	
	private String errStatus;
}
