package com.UHGUseCase.UserPolicies.Entity;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="Policy Claim")
public class PolicyClaim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private LocalDate claimDate;
	private String claimStatus;
	private long totalAmount;
	private double settledAmount;
	private double policyId;
	private double userId;
	private String hospitalName;
	
	public PolicyClaim() {
		super();
	}
	public PolicyClaim(long id, LocalDate claimDate, String claimStatus, long totalAmount, double settledAmount,double policyid,double userId,String hospitalName) {
		super();
		Id = id;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.totalAmount=totalAmount;
		this.settledAmount=settledAmount;
		this.policyId=policyid;
		this.userId=userId;
		this.setHospitalName(hospitalName);
	}
	public long getId() {
		return Id;
	}
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
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
