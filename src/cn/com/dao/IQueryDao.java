package cn.com.dao;

import java.util.List;

import cn.com.entity.AccountBook;
import cn.com.entity.QueryBook;

public interface IQueryDao {
	
	/*
	 * 查询消费记录列表
	 */
	public List<AccountBook> queryAccount(QueryBook queryBook);
	
	/**
	 * 通过消费记录ID查询对应的消费记录
	 */
    public AccountBook QueryByIdDao(int accountBookNum);
	
}
