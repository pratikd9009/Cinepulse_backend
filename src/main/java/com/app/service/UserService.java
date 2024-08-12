package com.app.service;

import com.app.dto.UserDTO;

public interface UserService {
    UserDTO registerUser(UserDTO userDto);
    UserDTO getUserByUsername(String username);
	UserDTO registerManager(UserDTO userDto);
	UserDTO registerAdmin(UserDTO userDto);
}