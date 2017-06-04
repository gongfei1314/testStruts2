package cn.com.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import cn.com.dao.IEditDao;
import cn.com.entity.AccountBook;
import cn.com.utills.JDBCObject;

public class EditDao implements IEditDao {

	public Connection conn = null;
	public PreparedStatement psmt = null;
	public ResultSet resultSet = null;
	public String sql = null;
	public int flag = 0;
	
	/**
	 * 增加消费记录
	 */
	@Override
	public int addConsume(AccountBook accountBook) {
		
		sql = "insert into accountbook(personCode,dateTime,typeCode,object,description,money,address,image,otherPersonCode) "
				+ "value(?,?,?,?,?,?,?,?,?)";
		conn = JDBCObject.getConnection();
		Timestamp t=new Timestamp(accountBook.getDateTime().getTime());
		System.out.println("test");
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,accountBook.getPersonCode() );
		    psmt.setTimestamp(2, t);
			psmt.setInt(3, accountBook.getTypeCode());
			psmt.setString(4, accountBook.getObject());
			psmt.setString(5, accountBook.getDescription());
			psmt.setDouble(6,accountBook.getMoney());
			psmt.setString(7, accountBook.getAddress());
		    psmt.setString(8, accountBook.getImagePath());
		    psmt.setString(9, accountBook.getOtherPersonCode());
		   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			flag = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(flag > 0){
			return flag;
		}
 
		return flag;
	}
	
	
	/**
	 * 删除消费记录
	 */
	@Override
	public void deleteConsume(int accountBookNum) {
		 Boolean bool = false;
		sql = "delete from accountBook where accountBookNum = ?";
		conn = JDBCObject.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, accountBookNum);
		    psmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public int editConsume(AccountBook accountBook) {
		sql = "update accountBook t set t.datetime=? ,t.typecode=?,t.object=?,t.description=?,money=?,t.address=?,t.image=?,otherPersonCode=? where t.accountBookNum=?";
		conn = JDBCObject.getConnection();
		Timestamp t=new Timestamp(accountBook.getDateTime().getTime());
		try {
			psmt = conn.prepareStatement(sql);
            psmt.setTimestamp(1, t);
            psmt.setInt(2,accountBook.typeCode );
			psmt.setString(3, accountBook.getObject());
			psmt.setString(4, accountBook.getDescription());
			psmt.setDouble(5,accountBook.getMoney());
			psmt.setString(6, accountBook.getAddress());
		    psmt.setString(7, accountBook.getImagePath());
		    psmt.setString(8, accountBook.getOtherPersonCode());
            psmt.setInt(9,accountBook.accountBookNum);
		    flag = psmt.executeUpdate();
		    if(flag > 0)
		    	return flag;
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return 0;
	}


}
