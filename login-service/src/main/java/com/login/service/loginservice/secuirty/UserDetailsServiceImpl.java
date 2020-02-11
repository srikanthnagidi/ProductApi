package com.login.service.loginservice.secuirty;

import com.login.service.loginservice.model.User;
import com.login.service.loginservice.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("inr UserDetails Service Implementation");
        Optional<User> optionalUser = userRepository.findUserByUsername(username);

        if (!optionalUser.isPresent()){
            throw new UsernameNotFoundException(username);
        }
		/*
		 * Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		 * optionalUser.get().getRoles().forEach(role -> { grantedAuthorities.add(new
		 * SimpleGrantedAuthority(role.getRoleName())); });
		 */
        return new org.springframework.security.core.userdetails.User(optionalUser.get().getUsername(), optionalUser.get().getPassword(), Collections.emptyList());
    }
}
