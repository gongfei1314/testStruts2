package cn.com.entity;

import java.io.Serializable;

/**
 * 
 * @author gongf
 *
 */


/*人员基本信息对象、*/
public class Person implements Serializable {
	public String name = null;
	public String sex = null;
	public int age = 0;
	public String identity = null;
	
   public Person(){}
   public Person(String name,String sex,int age,String identify){
	   this.name = name;
	   this.sex = sex;
	   this.age = age;
	   this.identity = identify;
   }
   
	
//getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	@Override
	public String toString() {
		return "{name:\"" + this.name + "\",sex:\"" + this.sex + "\",age:\"" + this.age + "\",identify:\"" + this.identity + "\"}";
//		return super.toString();
	}

}
