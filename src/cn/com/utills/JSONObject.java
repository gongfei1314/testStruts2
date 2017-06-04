package cn.com.utills;

import cn.com.entity.Person;

public class JSONObject {

	public static String fromObject(Person person){
		
		 String jsonString =  "{\"name\":\"" + person.name + "\",\"sex\":\"" + person.sex + "\",\"age\":\"" + person.age + "\",\"identify\":\"" + person.identity + "\"}";

		 
		return jsonString;
	}
}
