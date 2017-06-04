package cn.com.service.imp;

import cn.com.dao.ILoginDao;
import cn.com.dao.imp.LoginDao;
import cn.com.entity.User;
import cn.com.service.ILoginService;

public class LoginService implements ILoginService {
public ILoginDao iloginDao = null;
public int flag = 0;
	@Override
	public int login(User user) {
		iloginDao = new LoginDao();
	    flag =	iloginDao.login(user);
	    return flag;
		
	}

}
