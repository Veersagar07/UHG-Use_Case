package com.UHGUseCase.UserService.Repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.UHGUseCase.UserService.Entity.Role;
import com.UHGUseCase.UserService.Entity.ERole;

public interface RoleRepo extends JpaRepository<Role, Integer>{
	Optional<Role> findByName(ERole name);
}
