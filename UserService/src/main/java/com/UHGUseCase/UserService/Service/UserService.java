package com.UHGUseCase.UserService.Service;

import java.util.List;

import com.UHGUseCase.UserService.DTO.AuthenticationDTO;
import com.UHGUseCase.UserService.DTO.AuthnticationResponce;
import com.UHGUseCase.UserService.Entity.ERole;
import com.UHGUseCase.UserService.Entity.User;

public interface UserService {
	AuthnticationResponce loginUser(AuthenticationDTO authenticationDTO);
	List<User> findByUserId(long userId);
	void updateUser(long userId, User updatedUser, ERole roleName);
}
