package cn.com.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import cn.com.dao.ILoginDao;
import cn.com.entity.Person;
import cn.com.entity.User;
import cn.com.utills.JDBCObject;

public class LoginDao implements ILoginDao {
	
public  Connection conn = null;
public Statement stmt = null;
public PreparedStatement psmt;
public ResultSet rs = null;
public String sql = "select * from user t where ";
public User user = null;

	@Override
	public int login(User user) {
    conn = JDBCObject.getConnection();
// statement ∑Ω Ω
//    sql += "t.identify= '"+person.getIdentity()+"' and t.name= '"+person.getName()+"' ;";
//    try {
//		stmt = conn.createStatement();
//		rs = stmt.executeQuery(sql); 
//		while(rs.next()){
//			System.out.println(rs.getString(1));
//			System.out.println(rs.getString(2));
//			return 1;
//		}
//	} catch (SQLException e) {
//	
//		e.printStackTrace();
//	}
 /*
  * ‘§±‡“Î”Ôæ‰ 
  */
    sql += "t.password = ? and t.name = ?";
    try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, user.getPassword());
		psmt.setString(2, user.getName());
		rs = psmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			return 1;
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    
		return 0;
	}

}
