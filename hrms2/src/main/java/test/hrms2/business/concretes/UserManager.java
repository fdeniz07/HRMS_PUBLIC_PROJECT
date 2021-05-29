package test.hrms2.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.hrms2.business.abstracts.UserService;
import test.hrms2.core.results.DataResult;
import test.hrms2.core.results.SuccessDataResult;
import test.hrms2.dataAccess.abstracts.UserDao;
import test.hrms2.entities.abstracts.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao=userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {

		return new SuccessDataResult<List<User>>(userDao.findAll(), 
				"Kullanicilar basarili sekilde listelendi");
	}

}
