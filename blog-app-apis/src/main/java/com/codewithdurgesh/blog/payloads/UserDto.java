package com.codewithdurgesh.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min=4, message = "User Name must be minimum of 4 characters!!")
	private String name;
	
	@NotEmpty
	@Size(min = 4, max = 10, message = "Password must be min of 4 characters and max of 10 charachters !")
//	@Pattern(regexp = )
	private String password;
	
	@Email
	private String email;
	
	@NotEmpty
	private String about;
	

}
