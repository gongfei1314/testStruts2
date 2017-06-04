package cn.com.service.imp;


import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


import cn.com.entity.AccountBook;
import cn.com.entity.JsonBook;
import cn.com.entity.QueryBook;
import cn.com.service.IQueryService;
import cn.com.dao.IQueryDao;
import cn.com.dao.imp.QueryDao;

public class QueryService implements IQueryService {

	public IQueryDao iQueryDao = null;
	public List<AccountBook> accountBookList = null;
    public List<JsonBook> jsonBookList = null;
	public JsonBook jsonBook = null;
	
	@Override
	public List<JsonBook> QueryService(QueryBook queryBook) {
		iQueryDao = new QueryDao();
		
		accountBookList = new ArrayList<AccountBook>();
		accountBookList = iQueryDao.queryAccount(queryBook);
		jsonBookList = new ArrayList<JsonBook>();
		for(int i = 0;i < accountBookList.size(); i++){
//			jsonBook = new JsonBook(accountBookNum, personCode, dateTime, typeName, object, description, money, address, imagePath, otherPersonCode)
		   //消费类型
			String typeName = "";
			int typeCode = accountBookList.get(i).getTypeCode();
		    if(typeCode == 1){
		    	typeName = "生活用品";
		    }
		    else if(typeCode == 2){
		    	typeName = "服装";
		    }
		    else if(typeCode == 3){
		    	typeName = "电子产品";
		    }
		    else if(typeCode == 4){
		    	typeName = "培训费用";
		    }
		    else{
		    	typeName = "其他";
		    }
		    
		    //消费时间
	        String dateTime = accountBookList.get(i).dateTime.toString();
	        System.out.println(dateTime);
		    String[] date = dateTime.split(" ");
		    dateTime = date[1].toString();
		    dateTime += " "+date[2].toString();
		    dateTime += " "+date[5].toString();
		    System.out.println(dateTime);
			jsonBook = new JsonBook();
			jsonBook.setAccountBookNum(accountBookList.get(i).accountBookNum);
			jsonBook.setAddress(accountBookList.get(i).address);
			jsonBook.setDateTime(dateTime);
			jsonBook.setDescription(accountBookList.get(i).description);
			jsonBook.setImagePath(accountBookList.get(i).imagePath);
			jsonBook.setMoney(accountBookList.get(i).money);
			jsonBook.setObject(accountBookList.get(i).object);
			jsonBook.setOtherPersonCode(accountBookList.get(i).otherPersonCode);
			jsonBook.setPersonCode(accountBookList.get(i).personCode);
			jsonBook.setTypeName(typeName);
			
			jsonBookList.add(jsonBook);
		}
		
		
		return jsonBookList;
	}

	/**
	 * 通过AccountBookID查询
	 */
	@Override
	public JsonBook QueryByIdService(int accountBookNum) {
		iQueryDao = new QueryDao();
		AccountBook accountBook = iQueryDao.QueryByIdDao(accountBookNum);
		if(accountBook != null){

		jsonBook = new JsonBook();
		jsonBook.setAccountBookNum(accountBook.accountBookNum);
		jsonBook.setAddress(accountBook.address);
		jsonBook.setDateTime(accountBook.dateTime.toLocaleString().substring(0, 10));
		jsonBook.setDescription(accountBook.description);
		jsonBook.setImagePath(accountBook.imagePath);
		jsonBook.setMoney(accountBook.money);
		jsonBook.setObject(accountBook.object);
		jsonBook.setOtherPersonCode(accountBook.otherPersonCode);
		jsonBook.setPersonCode(accountBook.personCode);
		String type = ""+ accountBook.typeCode;
		jsonBook.setTypeName(type.trim());
		return jsonBook;
		
	}
		return null;
	}

}
