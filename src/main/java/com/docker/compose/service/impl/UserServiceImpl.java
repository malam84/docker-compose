package com.docker.compose.service.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.docker.compose.bean.Role;
import com.docker.compose.bean.User;
import com.docker.compose.repository.RoleRepository;
import com.docker.compose.repository.UserRepository;
import com.docker.compose.service.UserService;

/**
 * 
 * @author    Alam    
 * @2020
 */

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
    private PasswordEncoder bCryptPasswordEncoder; 
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                       PasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }
	
	@Override
	public User findUserByEmail(String email) {
	    return userRepository.findByEmail(email);
	}

	@Override
	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
	}

}
