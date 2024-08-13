package com.app.service;

import com.app.dto.UserDTO;
import com.app.entities.Role;
import com.app.entities.User;
import com.app.exception.ApiException;
import com.app.repository.UserRepository;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        // Check if username or email already exists
        if (userRepository.findByUsername(userDTO.getUsername()) != null) {
            throw new ApiException("Username already exists");
        }
        if (userRepository.findByEmail(userDTO.getEmail()) != null) {
            throw new ApiException("Email already exists");
        }

        User user = modelMapper.map(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user != null ? modelMapper.map(user, UserDTO.class) : null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    @Override
    public UserDTO registerAdmin(UserDTO userDto) {
        // Check if username or email already exists
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new ApiException("Username already exists");
        }
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new ApiException("Email already exists");
        }

        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ADMIN);
        User savedAdmin = userRepository.save(user);
        return modelMapper.map(savedAdmin, UserDTO.class);
    }

    @Override
    public UserDTO registerManager(UserDTO userDto) {
        // Check if username or email already exists
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new ApiException("Username already exists");
        }
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new ApiException("Email already exists");
        }

        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.MANAGER);
        User savedManager = userRepository.save(user);
        return modelMapper.map(savedManager, UserDTO.class);
    }
}