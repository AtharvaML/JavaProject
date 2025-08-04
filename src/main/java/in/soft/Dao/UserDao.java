package in.soft.Dao;

import java.util.List;
import java.util.Optional;

import in.soft.entity.User;

public interface UserDao {
	
	public String insert(User user);
	public List<User> get();
	public User search(int id);
	public String update(User user);
	public String delete(int id);

}
