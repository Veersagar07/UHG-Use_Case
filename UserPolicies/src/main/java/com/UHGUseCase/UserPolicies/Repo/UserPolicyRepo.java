package com.UHGUseCase.UserPolicies.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UHGUseCase.UserPolicies.DTO.PolicyDTO;
import com.UHGUseCase.UserPolicies.DTO.UserDTO;
import com.UHGUseCase.UserPolicies.DTO.UserPolicyDTO;
import com.UHGUseCase.UserPolicies.Entity.UserPolicies;

public interface UserPolicyRepo extends JpaRepository<UserPolicies, Long> {
	 List<UserPolicies> findByUserId(Integer userId);
	 List<UserPolicies> findByPolicyId(Integer policyId);
	 
	 @Query(value="SELECT * from `user-policies` where user_id=?1",nativeQuery = true)
	 List<UserPolicies> getPolicyByUserId(long userId);
}
