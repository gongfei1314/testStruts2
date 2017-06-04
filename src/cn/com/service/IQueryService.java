package cn.com.service;

import java.util.List;



import cn.com.entity.AccountBook;
import cn.com.entity.JsonBook;
import cn.com.entity.QueryBook;

public interface IQueryService {

	/*
	 * 查询消费记录列表
	 */
    public	List<JsonBook> QueryService(QueryBook queryBook);
    
    /**
     * 通过id查询消费记录
     */
    public JsonBook QueryByIdService(int accountBookNum);
	
}
