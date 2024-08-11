package com.app.dto;

<<<<<<< HEAD
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.app.entities.Role;

public class UserDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String lname;

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Role is mandatory")
    private Role role;

    // Getters and Setters

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "UserDTO [name=" + name + ", lname=" + lname + ", username=" + username + ", password=" + password
                + ", email=" + email + ", role=" + role + "]";
    }
=======
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

    
>>>>>>> 3960ae5a826b520eb895a48bfb31a818de2799f5
}
