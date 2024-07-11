package com.allduck.model;

import java.util.List;

public interface UserDAO {
	
	int addUser(UserDTO userDTO);
	UserDTO getUserByCode(int code_id);
	UserDTO getUserById(String id);
	List<UserDTO> getAllUsers();
	int updateUser(UserDTO user,int principalId);
	int deleteUser(int code_id); 

}
