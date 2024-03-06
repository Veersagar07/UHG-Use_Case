package com.UHGUseCase.UserPolicies.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UHGUseCase.UserPolicies.Entity.PolicyClaim;

public interface PolicyClaimRepo extends JpaRepository<PolicyClaim, Long>{
	 @Query(value="SELECT * from `policy claim` where user_id=?1",nativeQuery = true)
	 List<PolicyClaim> getPolicyClaimDetailsByUserId(long userId);
	 
}
