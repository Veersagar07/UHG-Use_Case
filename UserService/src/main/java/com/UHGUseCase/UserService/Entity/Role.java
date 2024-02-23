package com.UHGUseCase.UserService.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleId;
	
	
	@Enumerated(EnumType.STRING)
	private ERole name;
	
	

	public Role() {
		
	}
	
	 public Role(ERole name) {
		    this.name = name;
	 }

	public long getId() {
		return roleId;
	}

	public void setId(long roleId) {
		this.roleId = roleId;
	}

	public ERole geteRole() {
		return name;
	}

	public void seteRole(ERole name) {
		this.name = name;
	}
	
	
	@JsonCreator
	public static Role fromString(String roleName) {
		return new Role(ERole.valueOf(roleName));
	}
	
}
