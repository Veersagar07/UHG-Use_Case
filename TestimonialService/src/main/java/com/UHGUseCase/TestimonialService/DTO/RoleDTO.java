package com.UHGUseCase.TestimonialService.DTO;

public class RoleDTO {
	private long id;
	private String eRole;

	public RoleDTO() {
		super();
	}

	public RoleDTO(long id, String eRole) {
		super();
		this.id = id;
		this.eRole = eRole;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String geteRole() {
		return eRole;
	}

	public void seteRole(String eRole) {
		this.eRole = eRole;
	}

}
