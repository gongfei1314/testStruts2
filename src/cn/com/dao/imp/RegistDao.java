package cn.com.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.com.entity.User;
import cn.com.dao.IRegistDao;
import cn.com.utills.JDBCObject;



public class RegistDao implements IRegistDao {

public Connection conn = null;
public PreparedStatement psmt = null;
public ResultSet rs = null;
public String sql = null;
	@Override
	public int regist(User user) {
	sql = "insert into user(name,identify,password,sex,age,mobileTel) values(?,?,?,?,?,?)";
    conn = JDBCObject.getConnection();
    try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, user.name);
		psmt.setString(2, user.identify);  
		psmt.setString(3, user.password);
		psmt.setInt(4, user.sex);
		psmt.setInt(5, user.age);
		psmt.setString(6, user.mobileTel);
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
        try {
	    int  isOK = psmt.executeUpdate();
	    System.out.print(isOK);
	    return isOK;
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
     
        return 0;
		
		
		
	}




}
