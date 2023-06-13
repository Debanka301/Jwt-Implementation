package com.backend.JwtTry.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.backend.JwtTry.Entity.Users;
import com.backend.JwtTry.Repository.DummyRepository;

@Component
public class UsersInfoService implements UserDetailsService{
	
	@Autowired
	private DummyRepository dRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user= dRepo.findByName(username); 
		return  new UsersInfo(user);
	}

}
