package com.UHGUseCase.UserService.DTO;

public class AuthenticationDTO {
	private String email;
	private String password;
	
	public AuthenticationDTO() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
