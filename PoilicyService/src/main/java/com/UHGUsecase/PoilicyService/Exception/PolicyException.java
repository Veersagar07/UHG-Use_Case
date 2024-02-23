package com.UHGUsecase.PoilicyService.Exception;

public class PolicyException extends RuntimeException{
	private String message;

	public PolicyException(String message) {
		super();
		this.message = message;
	}

	public PolicyException() {
		super();
	}
	
}
