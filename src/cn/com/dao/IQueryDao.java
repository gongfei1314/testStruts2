package cn.com.dao;

import java.util.List;

import cn.com.entity.AccountBook;
import cn.com.entity.QueryBook;

public interface IQueryDao {
	
	/*
	 * ��ѯ���Ѽ�¼�б�
	 */
	public List<AccountBook> queryAccount(QueryBook queryBook);
	
	/**
	 * ͨ�����Ѽ�¼ID��ѯ��Ӧ�����Ѽ�¼
	 */
    public AccountBook QueryByIdDao(int accountBookNum);
	
}
