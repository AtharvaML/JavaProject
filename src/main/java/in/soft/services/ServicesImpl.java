package in.soft.services;

import java.util.List;
import java.util.Optional;

import in.soft.Dao.UserDao;
import in.soft.entity.User;
import in.soft.factory.DaoFactory;

public class ServicesImpl implements UserServices {
	
	UserDao dao=DaoFactory.getUserDao();
	String status;

	@Override
	public String uinsert(User user) {
		
		status=dao.insert(user);
		
		return status;
	}

	@Override
	public User usearch(int id) {
		User ss = dao.search(id);
		return ss;
	}

	@Override
	public String uupdate(User user) {
		String u = dao.update(user);
		return u;
	}

	@Override
	public String udelete(int id) {
		
		String del=dao.delete(id);
		
		return del;
	}

	@Override
	public List<User> getStu() {
		List<User> result=dao.get();
		return result;
	}

}
