package com.springboot.retail.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccCreationEmptyInputException extends RuntimeException {

	private String errorCode;

	private String errorMessage;

}
