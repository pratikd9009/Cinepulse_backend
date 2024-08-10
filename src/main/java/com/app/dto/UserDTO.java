package com.app.dto;

import com.app.entities.Role;

import java.util.Set;

public class UserDTO {
    private Long userId;
    private String name;
    private String lname;
    private String username;
    private String email;
    private Role role;
    private String password;

    // No bookings and ratings in DTO to simplify data transfer

    public UserDTO() {
    }

	public UserDTO( String name, String lname, String username, String email, Role role, String password) {
		super();
	
		this.name = name;
		this.lname = lname;
		this.username = username;
		this.email = email;
		this.role = role;
		this.password = password;
	}

	public UserDTO(String username2, String string) {
		this.username=username2;
		this.password=string;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", name=" + name + ", lname=" + lname + ", username=" + username
				+ ", email=" + email + ", role=" + role + ", password=" + password + "]";
	}

    
}
