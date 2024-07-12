package com.example.demo.model.entity;


import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"bookings"})
public class User {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.UUID) 
    	private UUID userId;

	 	
	 	
	    @NotNull(message = "Email cannot be null")
	    @Email(message = "Email should be valid")
	    @Column(nullable = false, length = 100, unique = true)
	    private String email;

	    @NotNull(message = "First name cannot be null")
	    @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
	    @Column(nullable = false, length = 50)
	    private String firstName;

	    @Size(max = 30, message = "Last name cannot be longer than 30 characters")
	    @Column(length = 30)
	    private String lastName;
	    
	    
	    @NotNull(message = "Phone number cannot be null")
	    @Pattern(regexp = "^\\d{10}$", message = "Phone number should be 10 digits")
	    @Column(nullable = false, length = 10, unique = true)
	    private String phoneNumber;

	    @NotNull(message = "Nationality cannot be null")
	    @Size(min = 1, max = 50, message = "Nationality must be between 1 and 50 characters")
	    @Column(nullable = false, length = 50)
	    private String nationality;
	    
	    
	    @NotNull(message = "Password cannot be null")
	    @Size(min = 8, message = "Password must be at least 8 characters")
	    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
	            message = "Password must have at least one uppercase letter, one lowercase letter, one digit, and one special character")
	    @Column(nullable = false)
	    private String password;
	
	

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	    private List<Booking> bookings;

	
	

}
