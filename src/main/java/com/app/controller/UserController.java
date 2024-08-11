package com.app.controller;

import java.util.HashMap;
import java.util.Map;
<<<<<<< HEAD

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
=======
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
<<<<<<< HEAD
import com.app.exception.ResourceNotFoundException;
=======
import com.app.entities.Role;
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
import com.app.security.JwtTokenProvider;
import com.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

<<<<<<< HEAD
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserController(UserService userService,
                          AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO registeredUser = userService.registerUser(userDTO);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam String username, @RequestParam String password) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );
        } catch (Exception e) {
            throw new ResourceNotFoundException("Invalid username or password");
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken((UserDetails) authentication.getPrincipal());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserDTO userDTO = userService.getUserByUsername(userDetails.getUsername());

        if (userDTO == null) {
            throw new ResourceNotFoundException("User not found");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", userDTO);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/admin/registration")
    public ResponseEntity<UserDTO> registerAdmin(@Valid @RequestBody UserDTO userDTO) {
        UserDTO registerAdmin = userService.registerAdmin(userDTO);
        return ResponseEntity.ok(registerAdmin);
    }

    @PostMapping("/admin/login")
    public ResponseEntity<Map<String, Object>> adminLogin(@RequestParam String userName, @RequestParam String password) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, password)
            );
        } catch (Exception e) {
            throw new ResourceNotFoundException("Invalid username or password");
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken((UserDetails) authentication.getPrincipal());
        UserDetails adminDetails = (UserDetails) authentication.getPrincipal();
        UserDTO userDTO = userService.getUserByUsername(adminDetails.getUsername());

        if (userDTO == null) {
            throw new ResourceNotFoundException("Admin not found");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", userDTO);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/manager/registration")
    public ResponseEntity<UserDTO> registerManager(@Valid @RequestBody UserDTO userDTO) {
        UserDTO registerManager = userService.registerManager(userDTO);
        return ResponseEntity.ok(registerManager);
    }

    @PostMapping("/manager/login")
    public ResponseEntity<Map<String, Object>> managerLogin(@RequestParam String userName, @RequestParam String password) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, password)
            );
        } catch (Exception e) {
            throw new ResourceNotFoundException("Invalid username or password");
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken((UserDetails) authentication.getPrincipal());
        UserDetails managerDetails = (UserDetails) authentication.getPrincipal();
        UserDTO userDTO = userService.getUserByUsername(managerDetails.getUsername());

        if (userDTO == null) {
            throw new ResourceNotFoundException("Manager not found");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", userDTO);

        return ResponseEntity.ok(response);
    }
=======
	private final UserService userService;
	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;

	@Autowired
	public UserController(UserService userService, AuthenticationManager authenticationManager,
			JwtTokenProvider jwtTokenProvider) {
		this.userService = userService;
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
		UserDTO registeredUser = userService.registerUser(userDTO);
		return ResponseEntity.ok(registeredUser);
	}


	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestParam String username, @RequestParam String password) {
		try {
			// Authenticate the user
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			SecurityContextHolder.getContext().setAuthentication(authentication);

			// Generate JWT token
			String token = jwtTokenProvider.generateToken((UserDetails) authentication.getPrincipal());

			// Fetch user details
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			UserDTO userDTO = userService.getUserByUsername(userDetails.getUsername());

			// Prepare the response
			Map<String, Object> response = new HashMap<>();
			response.put("token", token);
			response.put("user", userDTO);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}

	@PostMapping("/admin/registration")
	public ResponseEntity<UserDTO> registerAdmin(@RequestBody UserDTO userDTO) {

		UserDTO registerAdmin = userService.registerAdmin(userDTO);
		return ResponseEntity.ok(registerAdmin);

	}

	@PostMapping("/admin/login")
	public ResponseEntity<Map<String, Object>> adminLogin(@RequestParam String userName, @RequestParam String password) {
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
			SecurityContextHolder.getContext().setAuthentication(authentication);

			String token = jwtTokenProvider.generateToken((UserDetails) authentication.getPrincipal());

			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			UserDTO userDTO = userService.getUserByUsername(userDetails.getUsername());

			Map<String, Object> response = new HashMap<>();
			response.put("token", token);
			response.put("user", userDTO);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

		}
	}
	
	@PostMapping("/manager/registration")
	public ResponseEntity<UserDTO> registerManager(@RequestBody UserDTO userDTO) {

		UserDTO registerManager = userService.registerManager(userDTO);
		return ResponseEntity.ok(registerManager);
	}
	
	@PostMapping("/manager/login")
	public ResponseEntity<Map<String,Object>> managerLogin(@RequestParam String userName,@RequestParam String password){
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
			SecurityContextHolder.getContext().setAuthentication(authentication);

			String token = jwtTokenProvider.generateToken((UserDetails) authentication.getPrincipal());

			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			UserDTO userDTO = userService.getUserByUsername(userDetails.getUsername());

			Map<String, Object> response = new HashMap<>();
			response.put("token", token);
			response.put("user", userDTO);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

		}
	}
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
}
