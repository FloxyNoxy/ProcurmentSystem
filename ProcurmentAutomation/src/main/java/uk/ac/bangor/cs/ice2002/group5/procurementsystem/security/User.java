package uk.ac.bangor.cs.ice2002.group5.procurementsystem.security;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User class, uses UserDetails Interface from Spring Security to auto create working user system using custom variables e.g. role
 * 
 * @author Ethan Quilter
 *
 */
@Entity
@Data
public class User implements UserDetails{

	private static final long serialVersionUID = -1252518233417379119L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence") // Auto generated ID
	@EqualsAndHashCode.Exclude // exclude user ID field from equals and hash in Lombok
	@SequenceGenerator(
		    name = "user_sequence",
		    initialValue = 2,
		    allocationSize = 1
		)
	
	private Long userID;
	
	@Column(length = 255, unique = true, nullable = false, updatable = false)
	@Size(min = 1, max = 255)
	private String username;
	
	@Column(length = 255, nullable = false, updatable = false)
	@Size(min = 1, max = 255)
	private String fName;
	
	@Column(length = 255, nullable = false, updatable = false)
	@Size(min = 1, max = 255)
	private String lName;
	
	@Column(length = 255, nullable = false, updatable = false)
	@Size(min = 1, max = 255)
	private String roomNumber;
	
	@Column(length = 255, nullable = false, updatable = false)
	@Size(min = 1, max = 255)
	private String phoneNumber;
	
	@Column(length = 255, nullable = false, updatable = false)
	@Size(min = 1, max = 255)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String role;
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new LinkedList<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		
		return authorities;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getUserID() {
		return userID;
	}
	
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFName() {
		return fName;
	}
	
	public void setFName(String fName) {
		this.fName = fName;
	}
	
	public String getLName() {
		return lName;
	}
	
	public void setLName(String lName) {
		this.lName = lName;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}