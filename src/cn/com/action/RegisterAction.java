/**
 * @author gongf
 */
package cn.com.action;

import cn.com.entity.User;
import cn.com.service.IRegistService;
import cn.com.service.imp.RegistService;
public class RegisterAction  {


	public IRegistService iRegistService =null;
	public User user = null;
	public int flag = 0; 
	public String userName;
	public String identify;
	public String password;
	public String password2;
	public int age;
	public String mobileTel;
	public String sex;
	
	public String regist(){
		  user = new User();
		  user.name = this.userName;
		  user.identify = this.identify;
		  user.password = this.password;
		  user.age = this.age ;
		  user.mobileTel = this.mobileTel;
	
		  if(this.sex.toString().equals(new String("man")))
		     user.sex = 1;
		  else 
			 user.sex = 0;

            registr(user);
            
            if(flag == 1){

              return "success";
            }
            
           return "error";
	}
	
	
	public void registr(User user){
		  iRegistService = new RegistService();
          flag = iRegistService.regist(user);
	}


	
	public IRegistService getiRegistService() {
		return iRegistService;
	}


	public void setiRegistService(IRegistService iRegistService) {
		this.iRegistService = iRegistService;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getIdentify() {
		return identify;
	}


	public void setIdentify(String identify) {
		this.identify = identify;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getMobileTel() {
		return mobileTel;
	}


	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getPassword2() {
		return password2;
	}


	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	
	
}
