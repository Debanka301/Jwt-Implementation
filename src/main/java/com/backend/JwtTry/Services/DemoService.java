package com.backend.JwtTry.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.JwtTry.Entity.Users;
import com.backend.JwtTry.Repository.DummyRepository;

@Service
public class DemoService {
	
	@Autowired
	private DummyRepository drepo;
	
	public List<Users> getAllUsers(){
		return drepo.findAll();
	}

}
