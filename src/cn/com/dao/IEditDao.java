package cn.com.dao;

import cn.com.entity.AccountBook;

/*
 * auther gongfei
 * �޸��޸���¼
 */


public interface IEditDao {
    
	/*
	 * �������Ѽ�¼
	 */
	public int addConsume(AccountBook accountBook);
	
	/**
	 * ɾ�����Ѽ�¼
	 * @param accountBookNum
	 * @return
	 */
	public void deleteConsume(int accountBookNum);
	
	/**
	 * �޸����Ѽ�¼
	 */
	public int editConsume(AccountBook accountBook);
}
