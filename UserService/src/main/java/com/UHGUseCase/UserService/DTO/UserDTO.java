package com.UHGUseCase.UserService.DTO;

import java.util.HashSet;
import java.util.Set;


public class UserDTO {
	private long userId;
	private String firstName;
	private String lastName;
	private Long phone;
	private String email;
	private String password;
	private Set<String> roles = new HashSet<>();
	
	public long getId() {
		return userId;
	}
	public void setId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
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
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
}
