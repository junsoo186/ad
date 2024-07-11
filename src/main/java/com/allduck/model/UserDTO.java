package com.allduck.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private int code_id;
	private String name;
	private String age;
	private String gender;
	private String id;
	private String password;
	private String created_at;
	
}
