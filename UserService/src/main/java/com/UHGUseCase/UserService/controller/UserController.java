package com.UHGUseCase.UserService.controller;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import org.springframework.web.bind.annotation.PutMapping;
import com.UHGUseCase.UserService.DTO.AuthenticationDTO;
import com.UHGUseCase.UserService.DTO.AuthnticationResponce;
import com.UHGUseCase.UserService.DTO.UserDTO;
import com.UHGUseCase.UserService.Entity.ERole;
import com.UHGUseCase.UserService.Entity.Role;
import com.UHGUseCase.UserService.Entity.User;
import com.UHGUseCase.UserService.Repository.RoleRepo;
import com.UHGUseCase.UserService.Repository.UserRepo;
import com.UHGUseCase.UserService.Service.EmailService;
import com.UHGUseCase.UserService.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;

	@PostMapping("/signin")
	public ResponseEntity<?> loginUser(@RequestBody AuthenticationDTO authenticationDTO) {
		AuthnticationResponce authnticationResponce = userService.loginUser(authenticationDTO);
		String emailto = authenticationDTO.getEmail();
		emailService.signinSecurityAlertEmail(emailto);
		return ResponseEntity.ok(authnticationResponce);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody UserDTO userDto) {
		if (userRepo.existsByEmail(userDto.getEmail())) {
			return ResponseEntity.badRequest().body("Error: Email is already in use!");
		}

		User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getPhone(),
				userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));

		System.out.println(userDto.getRoles());
		Set<String> strRoles = userDto.getRoles();
		System.out.println(strRoles);
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepo.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);

		} else {
			strRoles.forEach(role -> {
				System.out.println(role);

				switch (role) {
				case "admin":
					Role adminRole = roleRepo.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				default:
					Role userRole = roleRepo.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepo.save(user);
		emailService.sendRegistrationSuccessEmail(userDto.getEmail(),userDto.getFirstName());
		return ResponseEntity.ok("User registered successfully!");
	}

	@GetMapping("/findByUser")
	public List<User> findByUserId(@RequestParam long userId) {
		System.out.println("Start");
		return userService.findByUserId(userId);
	}

	@GetMapping("/finduser")
	public List<User> findByEmail(@RequestParam String email) {
		return userRepo.findUser(email);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestParam long userId, @RequestBody User updatedUser) {
		ERole roleName = ERole.ROLE_USER;
		try {
			userService.updateUser(userId, updatedUser, roleName);
			return ResponseEntity.ok("User updated Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Updating User");
		}
	}
	
	@GetMapping("/findAll")
	public List<User> getAllUser(){
		return userService.findAll();
	}

}
