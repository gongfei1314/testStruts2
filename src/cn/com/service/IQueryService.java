package cn.com.service;

import java.util.List;



import cn.com.entity.AccountBook;
import cn.com.entity.JsonBook;
import cn.com.entity.QueryBook;

public interface IQueryService {

	/*
	 * ��ѯ���Ѽ�¼�б�
	 */
    public	List<JsonBook> QueryService(QueryBook queryBook);
    
    /**
     * ͨ��id��ѯ���Ѽ�¼
     */
    public JsonBook QueryByIdService(int accountBookNum);
	
}
