package cn.com.entity;

import java.util.Date;

/**
 * 
 * @author gongfei
 *将查询到的记录变为对象往jsp页面传递
 */
public class JsonBook {

	public int accountBookNum = 0;
	public String personCode = null;
	public String dateTime = null;
	public String typeName = null;
	public String object = null;
	public String description = null;
	public Double money = null;
	public String address = null;
	public String imagePath = null;
	public String otherPersonCode = null;
	
	public JsonBook(){}
	public JsonBook(int accountBookNum,String personCode,String dateTime,String typeName,String object 
			,String description, Double money,String address,String imagePath, String otherPersonCode){
		
		this.accountBookNum = accountBookNum;
		this.personCode = personCode;
		this.dateTime = dateTime;
		this.typeName = typeName;
		this.object = object;
		this.description = description;
		this.money = money;
		this.address = address;
		this.imagePath = imagePath;
		this.otherPersonCode = otherPersonCode;
				
	}
	
	public int getAccountBookNum() {
		return accountBookNum;
	}
	public void setAccountBookNum(int accountBookNum) {
		this.accountBookNum = accountBookNum;
	}
	public String getPersonCode() {
		return personCode;
	}
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getOtherPersonCode() {
		return otherPersonCode;
	}
	public void setOtherPersonCode(String otherPersonCode) {
		this.otherPersonCode = otherPersonCode;
	}
	
	
	
}
