package com.example.repository;

import com.example.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //UserDetails findByUsername(String username);
	UserDetails findByEmail(String email); // Custom query to find user by email
}
