package com.manju.csa.entity;

import com.manju.csa.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	private int userId;
	private String userName;
	private String email;
	private String password;
	
	private UserRole userRole;
	

}
