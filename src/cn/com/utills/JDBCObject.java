package cn.com.utills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBCObject {
public static Connection conn = null;
	public static Connection getConnection (){
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		String url ="jdbc:mysql://localhost:3306/accountdata?user=root&password=123456";
		
	  try {
		 conn = DriverManager.getConnection(url);
	} catch (SQLException e) {

		e.printStackTrace();
	}
		return conn;
	}
	
}
