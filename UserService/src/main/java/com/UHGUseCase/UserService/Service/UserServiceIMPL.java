package com.UHGUseCase.UserService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.UHGUseCase.UserService.DTO.AuthenticationDTO;
import com.UHGUseCase.UserService.DTO.AuthnticationResponce;
import com.UHGUseCase.UserService.Entity.ERole;
import com.UHGUseCase.UserService.Entity.Role;
import com.UHGUseCase.UserService.Entity.User;
import com.UHGUseCase.UserService.Repository.RoleRepo;
import com.UHGUseCase.UserService.Repository.UserRepo;

@Service
public class UserServiceIMPL implements UserService {

	AuthenticationDTO authenticationDTO;
	 	@Autowired
	    private UserRepo userRepo;
	 	
	 	@Autowired
	 	private RoleRepo roleRepo;
	 	
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	
  
	@Override
	public AuthnticationResponce loginUser(AuthenticationDTO authenticationDTO) {
        User user1 = userRepo.findByEmail(authenticationDTO.getEmail());
        System.out.print(authenticationDTO.getEmail());
        if (user1 != null) {
            String password = authenticationDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(authenticationDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new AuthnticationResponce("Login Success", true);
                } else {
                    return new AuthnticationResponce("Login Failed", false);
                }
            } else {
                return new AuthnticationResponce("password Not Match", false);
            }
        }else {
            return new AuthnticationResponce("Email not exits", false);
        }
	}
	
	public void updateUser(long userId,User updateUser, ERole roleName) {
	 User existingUSer=userRepo.findById(userId);
	 Role role = roleRepo.findByName(roleName).orElseGet(()->roleRepo.save(new Role(roleName)));
	 existingUSer.getRoles().add(role);
	 existingUSer.setEmail(updateUser.getEmail());
	 existingUSer.setFirstName(updateUser.getFirstName());
	 existingUSer.setLastName(updateUser.getLastName());
	 existingUSer.setPassword(passwordEncoder.encode(updateUser.getPassword()));
	 userRepo.save(existingUSer);
	 }

	@Override
	public List<User> findByUserId(long userId) {
		System.out.println("End");
		return userRepo.findByUserId(userId);
	}
	
}
