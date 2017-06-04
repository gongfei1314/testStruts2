/**
 * 
 */
/**
 * @author gongf
 *
 */
package cn.com.action;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import cn.com.service.IEditService;
import cn.com.service.IQueryService;
import cn.com.service.imp.EditService;





import cn.com.service.imp.QueryService;

import java.io.PrintWriter;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import net.sf.json.JSONObject;
import cn.com.entity.AccountBook;
import cn.com.entity.JsonBook;
import cn.com.entity.Person;

public class EditAction implements ServletResponseAware, ServletRequestAware{

	public AccountBook accountBook = null;
	public IEditService iEditService = null;
	public String flag;
	public  String myname = null;
	public  int accountType = 0;
	public String object = null;
	public Date time ;
	public Double money;
	public String descript;
	public String address;
	public String file = "imageth";
    public int accountBookNum ;

	public String otherPer;
	public String jsonString;
	public HttpServletRequest request;
	public HttpServletResponse response;
	public int number = 0;
	
	public int accountNum ;
	public String  description;
	public String otherPersonCode;
	public Date dateTime;
	public int typeCode;
	    
	    
/*
 * 增加消费记录
 */
    public String addConsume(){
	   
	    int flag = 0; 
        iEditService = new EditService();                    
	    HttpServletRequest request = ServletActionContext.getRequest();
	   
	    myname = (String) request.getSession().getAttribute("myname");
	    
        accountBook = new AccountBook((int)(Math.random()*100), myname, time, accountType, object,
        		descript, money, address, "imagePath", otherPer);
        flag = iEditService.addConsume(accountBook);
        jsonString = "添加成功";
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html,utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out;
		try {
			out = response.getWriter();
	        out.print(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return null;

   }


/**
 * 通过消防记录id查询消费记录
 */
public String  queryById(){
	IQueryService iQueryService = new QueryService();
	JsonBook jsonBook = iQueryService.QueryByIdService(number);
	request.setAttribute("accountId",jsonBook.accountBookNum );
	request.setAttribute("address",jsonBook.address );
	request.setAttribute("time",jsonBook.dateTime );
	request.setAttribute("description",jsonBook.description );
	request.setAttribute("imagePath",jsonBook.imagePath );
	request.setAttribute("money",jsonBook.money );
	request.setAttribute("object",jsonBook.object );
	request.setAttribute("otherPersonCode",jsonBook.otherPersonCode );
	request.setAttribute("typeName",jsonBook.typeName );
	
	try {
		request.getRequestDispatcher("../jsp/editCount.jsp").forward(request, response);
	} catch (ServletException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println(jsonBook);
	
	return null;
	

}

   
   /**
    * 修改修复记录
    */
   public String editAccountBook(){
       int flag = 0;  
   	   String message;
       iEditService = new EditService();
//       Date dateTime = null;
       String personCode = request.getSession().getAttribute("myname").toString();
//        int typeCode = new Integer(request.getParameter("accountType"));
//       String object = request.getParameter("object").toString();                        
//       
//       Format f = new SimpleDateFormat("yyyy-MM-dd");
//       try {
//   	 dateTime = (Date)(f.parseObject(request.getParameter("time"))) ;
//   	} catch (ParseException e1) {
//   		e1.printStackTrace();
//   	}
//       Double money = new Double(request.getParameter("money"));
//       String description = request.getParameter("descript");
//       String address = request.getParameter("address");
//       String imagePath = request.getParameter("file");
//       String otherPersonCode = request.getParameter("otherPer");
//       int accountNum = new Integer(request.getParameter("accountNum"));
       
       accountBook = new AccountBook(accountNum,personCode,dateTime,typeCode,
       		object,description,money,address,"image",otherPersonCode);
       flag = iEditService.editConsume(accountBook);
       
       if(flag > 0)
       	message = "修改保存成功";
       else
       	message = "修改保存失败";
       
       response.setContentType("text/html,utf-8");
       response.setCharacterEncoding("utf-8");
       PrintWriter out;
   	try {
   		out = response.getWriter();
   	    out.print(message);
   	    out.flush();
   	} catch (IOException e) {
   		e.printStackTrace();
   	}

       return null;
   }

/*
 * 
 * 删除消费记录
 */
public String deleteConsume(){
	

//	 int accountBookNum = new Integer(request.getParameter("accountBookNum")); 
	
	 System.out.println(accountBookNum);
	 
	 iEditService = new EditService();
	 iEditService.deleteConsume(accountBookNum);
	 
	 response.setContentType("text/html,utf-8");
	 response.setCharacterEncoding("utf-8");
	 PrintWriter out;
	try {
		out = response.getWriter();
		out.print("删除成功");
		out.flush();
	} catch (IOException e) {
		e.printStackTrace();
	}


	return null;
	
};




public int getNumber() {
	return number;
}

public void setNumber(int number) {
	this.number = number;
}

public AccountBook getAccountBook() {
	return accountBook;
}
public void setAccountBook(AccountBook accountBook) {
	this.accountBook = accountBook;
}

public IEditService getiEditService() {
	return iEditService;
}

public void setiEditService(IEditService iEditService) {
	this.iEditService = iEditService;
}
public String getFlag() {
	return flag;
}

public void setFlag(String flag) {
	this.flag = flag;
}
public String getMyname() {
	return myname;
}

public void setMyname(String myname) {
	this.myname = myname;
}
public int getAccountType() {
	return accountType;
}

public void setAccountType(int accountType) {
	this.accountType = accountType;
}

public String getObject() {
	return object;
}

public void setObject(String object) {
	this.object = object;
}

public Date getTime() {
	return time;
}

public void setTime(Date time) {
	this.time = time;
}

public Double getMoney() {
	return money;
}

public void setMoney(Double money) {
	this.money = money;
}

public String getDescript() {
	return descript;
}


public void setDescript(String descript) {
	this.descript = descript;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}

public String getFile() {
	return file;
}


public void setFile(String file) {
	this.file = file;
}


public String getOtherPer() {
	return otherPer;
}


public void setOtherPer(String otherPer) {
	this.otherPer = otherPer;
}

public String getJsonString() {
	return jsonString;
}

public void setJsonString(String jsonString) {
	this.jsonString = jsonString;
}

public int getAccountBookNum() {
	return accountBookNum;
}


public void setAccountBookNum(int accountBookNum) {
	this.accountBookNum = accountBookNum;
}


public int getAccountNum() {
	return accountNum;
}



public String getDescription() {
	return description;
}


public String getOtherPersonCode() {
	return otherPersonCode;
}


public void setAccountNum(int accountNum) {
	this.accountNum = accountNum;
}



public void setDescription(String description) {
	this.description = description;
}


public void setOtherPersonCode(String otherPersonCode) {
	this.otherPersonCode = otherPersonCode;
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


@Override
public void setServletRequest(HttpServletRequest request) {
	
	this.request = request;
	
}

@Override
public void setServletResponse(HttpServletResponse response) {
	this.response = response;
	
}
}	
   