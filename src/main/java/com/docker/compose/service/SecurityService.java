package com.docker.compose.service;

/**
 * 
 * @author    Alam    
 * @2020
 */

public interface SecurityService {

	String findLoggedInUsername();
    void autoLogin(String username, String password);
}
