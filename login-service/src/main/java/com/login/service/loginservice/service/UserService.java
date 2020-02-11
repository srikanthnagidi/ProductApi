package com.login.service.loginservice.service;

import com.login.service.loginservice.LoginServiceApplication;
import com.login.service.loginservice.model.User;
import com.login.service.loginservice.repos.RoleRepository;
import com.login.service.loginservice.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private Logger logger = LoggerFactory.getLogger(LoginServiceApplication.class);

	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		logger.info(user.getUsername() + " is created");
		userRepository.save(user);
	}

	public User findUserByUsername(String username) {
		Optional<User> optionalUser = userRepository.findUserByUsername(username);
		if (optionalUser.isPresent())
			return optionalUser.get();
		else
			throw new UsernameNotFoundException("no User with " + username);
	}
	
	public Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
}
