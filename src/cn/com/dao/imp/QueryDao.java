package cn.com.dao.imp;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.com.dao.IQueryDao;
import cn.com.entity.AccountBook;
import cn.com.entity.QueryBook;
import cn.com.utills.JDBCObject;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class QueryDao implements IQueryDao {
	
	public Connection conn = null;
	public PreparedStatement pst = null;
	public Statement st =null;
	public ResultSet rs = null;
	public List<AccountBook> list = null;
	public AccountBook accountBook = null;
	public String sql = null;
	

	@Override
	public List<AccountBook> queryAccount(QueryBook queryBook) {
 
		sql = "select * from accountbook t ";
//		sql = "select * from accountbook t  where t.typeCode =? and t.object like ? and t.dateTime between ? and ? ";
		
		if(queryBook.typeCode !=0){
			sql += " where  t.typeCode = " + queryBook.typeCode ;
		}
		
		if((queryBook.object != "")&&(queryBook.typeCode !=0)){
			sql += " and t.object like '%"+ queryBook.object +"%'";
		}
		else if((queryBook.object != "")&&(queryBook.typeCode ==0)){
			sql += " where t.object like '%"+ queryBook.object +"%'";
		}
		
		if((queryBook.starTime != "")&&(queryBook.endTime != "")){
			if((queryBook.typeCode == 0)&&(queryBook.object == ""))
				sql += " where t.dateTime between '"+ queryBook.starTime + "' and '"+ queryBook.endTime + "'";	
			else
			    sql += " and t.dateTime between '"+ queryBook.starTime + "' and '"+ queryBook.endTime + "'";
		}
		
		if((queryBook.typeCode ==0)&&(queryBook.object == "")&&(queryBook.starTime == "")&&(queryBook.endTime == "")&&(queryBook.personCode != "" )){
			sql += " where t.personCode = '" + queryBook.personCode +"'";
		}
		else if(queryBook.personCode != ""){
			sql += " and t.personCode = '"+ queryBook.personCode +"'";
		}
		
		
		System.out.println(sql);

		list = new ArrayList<AccountBook>();
		conn = JDBCObject.getConnection();
		try {
//			pst = conn.prepareStatement(sql);
//			pst.setInt(1, 1);
//			pst.setString(2,"%book%");
//			pst.setString(3, queryBook.getStarTime());
//			pst.setString(4, queryBook.getEndTime());
//			rs = pst.executeQuery();
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
			  accountBook = new AccountBook();
			  accountBook.setAccountBookNum(rs.getInt("accountBookNum")); 
			  accountBook.setAddress(rs.getString("address"));
			  java.sql.Date date = rs.getDate("dateTime"); 
			  java.util.Date dateTime = new Date(date.getTime());
			  accountBook.setDateTime(dateTime);
			  accountBook.setDescription(rs.getString("description"));
			  accountBook.setMoney(rs.getDouble("money"));
			  accountBook.setObject(rs.getString("object"));
			  accountBook.setPersonCode(rs.getString("personCode"));
			  accountBook.setOtherPersonCode(rs.getString("otherPersonCode"));
			  accountBook.setImagePath(rs.getString("image"));
			  accountBook.setTypeCode(rs.getInt("typeCode"));
			  
			  list.add(accountBook);
			}
			
			AccountBook test = list.get(0);
			System.out.println(test.description);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public AccountBook QueryByIdDao(int accountBookNum) {
		sql = "select * from accountbook t where t.accountBookNum = ?";
		conn = JDBCObject.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, accountBookNum);
			rs =pst.executeQuery();
			while(rs.next()){
				  accountBook = new AccountBook();
				  accountBook.setAccountBookNum(rs.getInt("accountBookNum")); 
				  accountBook.setAddress(rs.getString("address"));
				  java.sql.Date date = rs.getDate("dateTime"); 
				  java.util.Date dateTime = new Date(date.getTime());
				  accountBook.setDateTime(dateTime);
				  accountBook.setDescription(rs.getString("description"));
				  accountBook.setMoney(rs.getDouble("money"));
				  accountBook.setObject(rs.getString("object"));
				  accountBook.setPersonCode(rs.getString("personCode"));
				  accountBook.setOtherPersonCode(rs.getString("otherPersonCode"));
				  accountBook.setImagePath(rs.getString("image"));
				  accountBook.setTypeCode(rs.getInt("typeCode"));
				  System.out.println(rs.getString("object"));
				  return accountBook;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
