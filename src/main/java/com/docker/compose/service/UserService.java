package com.docker.compose.service;

import com.docker.compose.bean.User;

/**
 * 
 * @author    Alam    
 * @2020
 */

public interface UserService {

	 public User findUserByEmail(String email);
	 public User findUserByUserName(String userName);
	 public User saveUser(User user);
}
