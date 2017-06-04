
/**
 * @author gongf
 *
 */
package cn.com.action;
import java.io.IOException;
import java.util.Map;




import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;

import cn.com.entity.User;
import cn.com.service.ILoginService;
import cn.com.service.imp.LoginService;

public class LoginAction implements ServletRequestAware {
	


public ILoginService iloginService = null;
public HttpServletRequest request = null;
public User user = null;
public int flag = 0; //判断是否能登录，返回1能，0否；
public String userName;
public String userPassword;

//action 访问函数
public String login(){
	user  = new User();
	user.name = this.userName;
	user.password = this.userPassword;		
    login(user);
//    ActionContext actionContext = ActionContext.getContext();
//    Map<String, Object> seesion = actionContext.getSession();
//    seesion.put("myname", user.name);
     request.getSession().setAttribute("myname", user.name);
    
//    request.getSession().setAttribute("myname", user.name);
    
    if(flag == 1){
    
//      response.setContentType("text/html;charset=utf-8");   
//    	response.setContentType("text/html;charset=gb2312");
//    	response.sendRedirect("../jsp/main.jsp"); 
    	return "success";
      
//    	request.getRequestDispatcher("../jsp/main.jsp").forward(request, response);   //转发
    }
    else
    {

    	return "error";
    }
  
}

@Override
public void setServletRequest(HttpServletRequest request) {
	
	this.request = request;
	
}

public int login(User user){ 

	iloginService = new LoginService();
	flag = iloginService.login(user);
 	
    System.out.println(flag);
    return flag;
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

public String getUserPassword() {
	return userPassword;
}

public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}







}     