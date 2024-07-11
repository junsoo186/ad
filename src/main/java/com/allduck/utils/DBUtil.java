package com.allduck.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	
	private static DataSource dataSource;
	
	static {
		
		try {

			InitialContext ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/MyDB");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
}