package cn.com.service.imp;
import cn.com.entity.AccountBook;
import cn.com.service.IEditService;
import cn.com.dao.IEditDao;
import cn.com.dao.imp.EditDao;




public class EditService implements IEditService{

    public IEditDao iEditDao = null;
    public int flag = 0;


	/**
	 * 添加消费记录
	 */
	@Override
	public int addConsume(AccountBook accountBook) {
		

		iEditDao = new EditDao();
		flag = iEditDao.addConsume(accountBook);
		if(flag >0)
			return flag;
		
		return flag;
	}


	/**
	 * 删除消费记录
	 */
	@Override
	public void deleteConsume(int accountBookNum) {
		iEditDao = new EditDao();
		iEditDao.deleteConsume(accountBookNum);

	}

   /**
    * 修改消费记录
    */
	@Override
	public int editConsume(AccountBook accountBook) {
		iEditDao = new EditDao();
		flag = iEditDao.editConsume(accountBook);
		if(flag >0)
			return flag;
		return 0;
	}

}
