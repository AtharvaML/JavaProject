package in.soft.services;

import java.util.List;
import java.util.Optional;

import in.soft.entity.User;

public interface UserServices {
	
	public String uinsert(User user);
	public List<User> getStu();
	public User usearch(int id);
	public String uupdate(User user);
	public String udelete(int id);

}
