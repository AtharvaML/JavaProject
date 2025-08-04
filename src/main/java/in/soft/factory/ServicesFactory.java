package in.soft.factory;

import in.soft.services.ServicesImpl;
import in.soft.services.UserServices;

public class ServicesFactory {
	
	private static UserServices userservices=null;
	
	static
	{
		userservices=new ServicesImpl();
	}
	
	public static  UserServices getUserServices() {
		return userservices;
	}
	

}
