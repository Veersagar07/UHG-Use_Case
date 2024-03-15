package com.UHGUseCase.UserPolicies.Repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UHGUseCase.UserPolicies.Entity.PolicyClaim;

public interface PolicyClaimRepo extends JpaRepository<PolicyClaim, Long>{
	 @Query(value="SELECT * from `policy claim` where user_id=?1",nativeQuery = true)
	 List<PolicyClaim> getPolicyClaimDetailsByUserId(long userId);
	 
	 @Query(value="SELECT * from `policy claim` where claim_status=?1",nativeQuery = true)
	 List<PolicyClaim> getPendingClaims(String claimStatus);
	 
	 @Query(value="SELECT * FROM `policy claim` WHERE user_id = ?1 AND policy_id = ?2", nativeQuery = true)
	 Optional<PolicyClaim> findByUserIdAndPolicyId(long userId,long policyId);
}
