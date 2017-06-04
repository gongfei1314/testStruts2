package cn.com.dao;

import cn.com.entity.User;

/**
 * 
 * @author gongf
 * 
 *
 */
//查询库中是否有此用户
public interface ILoginDao {

	public int login(User user);
}

