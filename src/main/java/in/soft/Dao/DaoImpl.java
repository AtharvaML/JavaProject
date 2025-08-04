package in.soft.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import in.soft.entity.User;
import in.soft.factory.ConnectionFactory;

public class DaoImpl implements UserDao {
	
	Connection con=ConnectionFactory.getConnection();
	String ql;
	String status;
	
	User u=new User();

	@Override
	public String insert(User user) {
		
		try {
			
			int sid=user.getSid();
			String sname=user.getSname();
			float smarks=user.getSmarks();
			String sadd=user.getSadd();
			String ssec=user.getSsec();
			int sstd=user.getSstd();
			
			ql="insert into student values(?,?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(ql);
			
			ps.setInt(1, sid);
			ps.setString(2, sname);
			ps.setFloat(3, smarks);
			ps.setString(4, sadd);
			ps.setString(5, ssec);
			ps.setInt(6, sstd);
			
			
			ps.execute();
			
			status="success";
			
			
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public User search(int id) {
	    User u = null; 

	    try {
	        ql = "select * from student where sid=?";
	        PreparedStatement ps = con.prepareStatement(ql);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            u = new User();  
	            u.setSid(rs.getInt("sid"));
	            u.setSname(rs.getString("sname"));
	            u.setSmarks(rs.getFloat("smarks"));
	            u.setSadd(rs.getString("sadd"));
	            u.setSsec(rs.getString("ssec"));
	            u.setSstd(rs.getInt("sstd"));

	            status = "success";
	        } else {
	            System.out.println(id);
	        }

	    } catch (Exception e) {
	        status = "failure";
	        e.printStackTrace();
	    }

	    return u;  
	}

	@Override
	public String update(User user) {
		
		int id1=user.getSid();
		String name1=user.getSname();
		float marks1=user.getSmarks();
		String add1=user.getSadd();
		String sec1=user.getSsec();
		int std1=user.getSstd();
		

		try {
			ql="UPDATE student SET sname=?,smarks=?,sadd=?,ssec=?,sstd=? WHERE sid=?";
			PreparedStatement ps=con.prepareStatement(ql);
			
			ps.setInt(6, id1);
			ps.setString(1, name1);
			ps.setFloat(2, marks1);
			ps.setString(3, add1);
			ps.setString(4, sec1);
			ps.setInt(5, std1);
			
			int i=ps.executeUpdate();
			
			
			if(i==1)
			{
				return status= "success";
			}else {
				status=null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		

	}

	@Override
	public String delete(int id) {
		
		try {
			
			ql="delete from student where sid=?";
			
			PreparedStatement ps=con.prepareStatement(ql);
			
			ps.setInt(1, id);
			
			boolean b=ps.execute();
			
			if(b!=true)
			{
				status="delete successfully";
			}
			
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		
		
		return status;
	}

	@Override
	public List<User> get() {
		
		List<User> us=new ArrayList<User>();
		
		try {
			
			ql="select * from student";
			
			PreparedStatement ps=con.prepareStatement(ql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				User u=new User();
				
				u.setSid(Integer.parseInt(rs.getString("sid")));
				u.setSname(rs.getString("sname"));
				u.setSmarks(Float.parseFloat(rs.getString("smarks")));
				u.setSadd(rs.getString("sadd"));
				u.setSsec(rs.getString("ssec"));
				u.setSstd(Integer.parseInt(rs.getString("sstd")));
				
				us.add(u);
			}
			
		} catch (Exception e) {
			
			status="failure";
			e.printStackTrace();
		}
		return us;
	}
	

}
