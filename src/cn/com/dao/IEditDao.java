package cn.com.dao;

import cn.com.entity.AccountBook;

/*
 * auther gongfei
 * 修改修复记录
 */


public interface IEditDao {
    
	/*
	 * 增加消费记录
	 */
	public int addConsume(AccountBook accountBook);
	
	/**
	 * 删除消费记录
	 * @param accountBookNum
	 * @return
	 */
	public void deleteConsume(int accountBookNum);
	
	/**
	 * 修改消费记录
	 */
	public int editConsume(AccountBook accountBook);
}
