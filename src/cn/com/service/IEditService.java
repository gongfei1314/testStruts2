package cn.com.service;

import cn.com.entity.AccountBook;
/**
 * 
 * @author gongfei
 * ���˵���¼������Ӧ����
 */
public interface IEditService {

	/*
	 * �������Ѽ�¼
	 */
	public int addConsume(AccountBook accountBook);
	
	/**
	 * ɾ�����Ѽ�¼
	 */
	public void deleteConsume(int accountBookNum);
	
	/**
	 * �޸����Ѽ�¼
	 */
	public int editConsume(AccountBook accountBook);

}
