package cn.com.service;

import cn.com.entity.AccountBook;
/**
 * 
 * @author gongfei
 * 对账单记录进行相应操作
 */
public interface IEditService {

	/*
	 * 增加消费记录
	 */
	public int addConsume(AccountBook accountBook);
	
	/**
	 * 删除消费记录
	 */
	public void deleteConsume(int accountBookNum);
	
	/**
	 * 修改消费记录
	 */
	public int editConsume(AccountBook accountBook);

}
