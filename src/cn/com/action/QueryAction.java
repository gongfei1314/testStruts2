package cn.com.action;

/**
 * 
 * @author gongf
 *
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;



import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.com.entity.AccountBook;
import cn.com.entity.JsonBook;
import cn.com.entity.QueryBook;
import cn.com.service.IQueryService;
import cn.com.service.imp.QueryService;

/*
 * 查询消费记录
 */
public class QueryAction implements ServletRequestAware {
	
	public IQueryService iQueryService = new QueryService();
	public List<AccountBook> accountBookList = null;
	public List<JsonBook> jsonBookList = null; 
	public QueryBook queryBook = null;
	public HttpServletRequest request = null;
	public HttpServletResponse response = null;
	public String typeCode = null;
	public String startTime = null;
	public String endTime = null;
	public String object = null;

	

	public String queryBooks(){
		
		response = ServletActionContext.getResponse();
		String typeConsume = this.typeCode;
		int typeCode = 0;
		if(null != typeConsume){
		   typeCode =  new Integer(typeConsume);
		}
		String startTime = this.startTime;
		String endTime = this.endTime;
		String object = this.object;
		String personCode = request.getSession().getAttribute("myname").toString();
		
		queryBook = new QueryBook();
		queryBook.setTypeCode(typeCode);
		if((null != personCode)&&("" != personCode)){
			queryBook.setPersonCode(personCode);
		}
		if((null != startTime)&&(null != endTime)&&(!"".equals(startTime))&&(!"".equals(endTime))){
		   queryBook.setStarTime(startTime);
		   queryBook.setEndTime(endTime);
		}
		if((null != object)&&(!"".equals(object))){
			queryBook.setObject(object);
		}
			
		  
	
		
		jsonBookList = iQueryService.QueryService(queryBook);
		
		JSONArray jsonArray = JSONArray.fromObject(jsonBookList);
		
		System.out.println("hello");
//		JSONObject jsobject = JSONObject.fromObject(accountBookList.get(1));
	
//		JSONObject jsobject = JSONObject.fromObject(accountBook);
//		JSONArray jsonArray = new JSONArray();
//		jsonArray.add(1,jsobject);

		response.setContentType("text/html,utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(jsonArray);
			out.flush();
            out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}



	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.request = request;
	}

	
	
	


	public IQueryService getiQueryService() {
		return iQueryService;
	}



	public void setiQueryService(IQueryService iQueryService) {
		this.iQueryService = iQueryService;
	}



	public List<AccountBook> getAccountBookList() {
		return accountBookList;
	}



	public void setAccountBookList(List<AccountBook> accountBookList) {
		this.accountBookList = accountBookList;
	}
	public QueryBook getQueryBook() {
		return queryBook;
	}



	public void setQueryBook(QueryBook queryBook) {
		this.queryBook = queryBook;
	}



	public HttpServletRequest getRequest() {
		return request;
	}



	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}



	public HttpServletResponse getResponse() {
		return response;
	}



	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}



	public String getTypeCode() {
		return typeCode;
	}



	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}



	public String getStartTime() {
		return startTime;
	}



	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public String getEndTime() {
		return endTime;
	}



	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}



	public String getObject() {
		return object;
	}



	public void setObject(String object) {
		this.object = object;
	}
		



}
