package in.soft.factory;

import in.soft.Dao.DaoImpl;
import in.soft.Dao.UserDao;

public class DaoFactory {
	
	private static UserDao userdao=null;
	
	static {
		 userdao=new DaoImpl();
		 
	}
	
	public static UserDao getUserDao()
	{
		return userdao;
	}

}
