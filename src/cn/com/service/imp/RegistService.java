package cn.com.service.imp;

import cn.com.dao.IRegistDao;
import cn.com.dao.imp.RegistDao;
import cn.com.service.IRegistService;
import cn.com.entity.User;


public class RegistService implements IRegistService {

	public IRegistDao iregistDao = null;
	@Override
	public int regist(User user) {
		int flag = 0;
		iregistDao = new RegistDao();
		
		flag =iregistDao.regist(user);
		return flag;
	}


}
