package com.UHGUseCase.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.UHGUseCase.UserService.Entity.User;

import java.lang.Integer;
import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
	Boolean existsByEmail(String email);

	User findByEmail(String email);

	@Query(value = "Select * from insurance_users where email=?1", nativeQuery = true)
	public List<User> findUser(String email);

	Optional<User> findOneByEmailAndPassword(String email, String encodedPassword);

	@Query(value = "Select * from insurance_users where user_id=?1", nativeQuery = true)
	public List<User> findByUserId(long userId);

	User findById(long userId);

	
}