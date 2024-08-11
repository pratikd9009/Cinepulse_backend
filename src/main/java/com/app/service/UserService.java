package com.app.service;

import com.app.dto.UserDTO;

public interface UserService {
    UserDTO registerUser(UserDTO userDto);
    UserDTO getUserByUsername(String username);
<<<<<<< HEAD
	UserDTO registerManager(UserDTO userDto);
	UserDTO registerAdmin(UserDTO userDto);
=======
    UserDTO registerAdmin(UserDTO userDto);
	UserDTO registerManager(UserDTO userDTO);
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
}
