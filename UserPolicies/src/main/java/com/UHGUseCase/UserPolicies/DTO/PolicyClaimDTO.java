package com.UHGUseCase.UserPolicies.DTO;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class PolicyClaimDTO {
	private long Id;
	private LocalDate claimDate;
	private String claimStatus;
	private long totalAmount;
	private double settledAmount;
	private double policyId;
	private double userId;
	private String hospitalName;

	public PolicyClaimDTO() {
		super();
	}

	public PolicyClaimDTO(long id, LocalDate claimDate, String claimStatus, long totalAmount, double settledAmount,
			double policyId, double userId, String hospitalName) {
		super();
		Id = id;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.totalAmount = totalAmount;
		this.settledAmount = settledAmount;
		this.policyId = policyId;
		this.userId = userId;
		this.hospitalName = hospitalName;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getSettledAmount() {
		return settledAmount;
	}

	public void setSettledAmount(double settledAmount) {
		this.settledAmount = settledAmount;
	}

	public double getPolicyId() {
		return policyId;
	}

	public void setPolicyId(double policyId) {
		this.policyId = policyId;
	}

	public double getUserId() {
		return userId;
	}

	public void setUserId(double userId) {
		this.userId = userId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

}
