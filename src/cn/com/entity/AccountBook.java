package cn.com.entity;

import java.io.Serializable;
import java.util.Date;

//消费记录对象
public class AccountBook implements Serializable {

	public int accountBookNum = 0;
	public String personCode = null;
	public Date dateTime = null;
	public int typeCode = 0;
	public String object = null;
	public String description = null;
	public Double money = null;
	public String address = null;
	public String imagePath = null;
	public String otherPersonCode = null;
	
	
	public AccountBook(){}
	public AccountBook(int accountBookNum,String personCode,Date dateTime,int typeCode,String object,String description
			,Double money,String address,String imagePath,String otherPersonCode){
		this.accountBookNum = accountBookNum;
		this.personCode = personCode;
		this.dateTime = dateTime;
		this.typeCode = typeCode;
		this.object = object;
		this.description = description;
		this.money = money;
		this.address = address;
		this.imagePath = imagePath;
		this.otherPersonCode = otherPersonCode;
		
	} 
	
	//getter and setter
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
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public int getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
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
