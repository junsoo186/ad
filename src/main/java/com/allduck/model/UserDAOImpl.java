package com.allduck.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;



public class UserDAOImpl implements UserDAO {
	private ResultSet rs; 
	private DataSource dataSource;

	public UserDAOImpl() {

		try {
			InitialContext ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDB");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int addUser(UserDTO userDTO) {
		int resultCount = 0;
		String sql = " INSERT INTO user(name, age, gender,id,password) VALUES (?,?,?,?,?) ";
		try (Connection conn = dataSource.getConnection()) {
			// 트랜잭션 시작
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, userDTO.getName());
				pstmt.setInt(2, Integer.parseInt(userDTO.getAge()));
				pstmt.setString(3, userDTO.getGender());
				pstmt.setString(4, userDTO.getId());
				pstmt.setString(5, userDTO.getPassword());
				resultCount = pstmt.executeUpdate();
				// 트랜잭션 커밋
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			} // end of PreparedStatement
		} catch (Exception e) {
			e.printStackTrace();
		} // end of Connection
		return resultCount;
	}

	@Override
	public UserDTO getUserByCode(int code_id) {
		String sql=" select * from users where id = ? ";
		UserDTO userDTO=null;
		try (Connection conn=dataSource.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(sql)){
				pstmt.setInt(1, code_id);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					userDTO=new UserDTO();
					userDTO.setCode_id(rs.getInt("code_id"));
					userDTO.setName(rs.getString("name"));
					userDTO.setAge(rs.getString("age"));
					userDTO.setGender(rs.getString("gender"));
					userDTO.setId(rs.getString("id"));
					userDTO.setPassword(rs.getString("password"));
					userDTO.setCreated_at(rs.getString("created_at"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("UsetDTO : "+userDTO.toString());
		return userDTO;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(UserDTO user, int principalId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int code_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserDTO getUserById(String id) {
		String sql=" select * from users where username = ? ";
		UserDTO userDTO=null;
		try (Connection conn=dataSource.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(sql)){
				pstmt.setString(1, id);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					userDTO=new UserDTO();
					userDTO.setCode_id(rs.getInt("code_id"));
					userDTO.setName(rs.getString("name"));
					userDTO.setAge(rs.getString("age"));
					userDTO.setGender(rs.getString("gender"));
					userDTO.setId(rs.getString("id"));
					userDTO.setPassword(rs.getString("password"));
					userDTO.setCreated_at(rs.getString("created_at"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("UsetDTO By Username : "+userDTO.toString());
		return userDTO;
	}
	

}
