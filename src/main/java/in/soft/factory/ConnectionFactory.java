package in.soft.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static Connection cn=null;
	
	static {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/clg","root","root");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		return cn;
	}

}
