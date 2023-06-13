package com.backend.JwtTry.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.JwtTry.Entity.Users;

@Repository
public interface DummyRepository extends JpaRepository<Users, Integer>{

	Users findByName(String name);
}
