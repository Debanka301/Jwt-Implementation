package com.backend.JwtTry.Controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.JwtTry.Entity.Users;
import com.backend.JwtTry.Services.DemoService;
import com.backend.JwtTry.Services.JwtService;
import com.backend.JwtTry.dto.AuthRequest;

@RestController
public class HomeController {
	
	@Autowired
	private DemoService demoService;
	
	@Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
	
	@GetMapping("/users")
	@PreAuthorize("hasAuthority('Admin')")
	public List<Users> getAllUsers() {
		return demoService.getAllUsers();
	}
	
	@GetMapping("/message")
	@PreAuthorize("hasAuthority('Admin')")
	public String getMessage() {
		return "This is only for Admin";
	}
	
	@GetMapping("/user-message")
	@PreAuthorize("hasAuthority('User')")
	public String getMessageForUser() {
		return "This is only for User";
	}
	
	 @PostMapping("/login")
	    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
	        if (authentication.isAuthenticated()) {
	            return jwtService.generateToken(authRequest.getName());
	        } else {
	            throw new UsernameNotFoundException("invalid user request !");
	        }


	    }

}
