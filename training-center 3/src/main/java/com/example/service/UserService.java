package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Get All Users
    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        List<User> users = userRepository.findAll();
        logger.info("Fetched {} users", users.size());
        return users;
    }

    // Get User by ID
    public Optional<User> getUserById(Integer id) {
        logger.info("Fetching user by ID: {}", id);
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            logger.info("Found user with ID: {}", id);
        } else {
            logger.warn("User with ID {} not found", id);
        }
        return user;
    }

    // Save a New User
    public User saveUser(User user) {
        logger.info("Saving new user with email: {}", user.getEmail());
        User savedUser = userRepository.save(user);
        logger.info("Saved new user with ID: {}", savedUser.getUserId());
        return savedUser;
    }

    // Update Existing User
    public User updateUser(Integer id, User updatedUser) {
        logger.info("Updating user with ID: {}", id);
        return userRepository.findById(id).map(user -> {
            ((User) user).setFirstName(updatedUser.getFirstName());
            ((User) user).setLastName(updatedUser.getLastName());
            ((User) user).setEmail(updatedUser.getEmail());
            ((User) user).setPassword(updatedUser.getPassword());
            ((User) user).setGender(updatedUser.getGender());
            ((User) user).setBirthday(updatedUser.getBirthday());
            ((User) user).setCity(updatedUser.getCity());
            ((User) user).setPhoneNo(updatedUser.getPhoneNo());
            ((User) user).setRole(updatedUser.getRole());
            User savedUser = (User) userRepository.save(user);
            logger.info("Updated user with ID: {}", savedUser.getUserId());
            return savedUser;
        }).orElseThrow(() -> {
            logger.warn("User with ID {} not found", id);
            return new RuntimeException("User not found");
        });
    }

    // Delete User
    public void deleteUser(Integer id) {
        logger.info("Deleting user with ID: {}", id);
        userRepository.deleteById(id);
        logger.info("Deleted user with ID: {}", id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
            //.orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }
	
	
    public String create(String email, String password) {
        User user = User.builder()
            .email(email)
            .password(new BCryptPasswordEncoder().encode(password))
            .authorities("USER")
            .build();
        userRepository.save(user);
        return "User Created Successfully!";
    }

    
    
}
