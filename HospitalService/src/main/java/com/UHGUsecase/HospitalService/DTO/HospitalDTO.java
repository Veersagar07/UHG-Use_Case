package com.UHGUsecase.HospitalService.DTO;

public class HospitalDTO {
	private Integer hospitalId;
	private String hospitalName;
	private String city;
	private String state;
	private Long pin;

	public HospitalDTO() {
		super();
	}

	public HospitalDTO(Integer hospitalId, String hospitalName, String city, String state, Long pin) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

}
