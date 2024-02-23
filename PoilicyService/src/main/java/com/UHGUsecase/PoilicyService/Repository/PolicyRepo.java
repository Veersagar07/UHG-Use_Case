package com.UHGUsecase.PoilicyService.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UHGUsecase.PoilicyService.Entity.Policy;

public interface PolicyRepo extends JpaRepository<Policy, Integer>{
	
	@Query(value="Select * from Policy where policy_name=?1",nativeQuery=true)
	public Policy findByPolicyName(String policy_name);

	@Query(value="Select * from Policy where policy_id=?1",nativeQuery=true)
	public List<Policy> findByPolicyId(long id);
	
	
//	Policy findByPolicyName(String Policy);
	
}
