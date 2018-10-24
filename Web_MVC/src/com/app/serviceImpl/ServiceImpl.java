package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daoI.DaoI;
import com.app.model.User;
import com.app.serviceI.ServiceI;
@Service
public class ServiceImpl implements ServiceI {
@Autowired
DaoI di;
	@Override
	public int saveUser(User u) {
		
		return di.saveUser(u);
	}

	@Override
	public List<User> loginUser(String uname, String pass) {
		
		return di.loginUser(uname, pass);
	}

	@Override
	public List<User> deleteUser(int id) {
		
		return di.deleteUser(id);
	}

	@Override
	public User editData(int id) {
		
		return di.editData(id);
	}

	@Override
	public List<User> updatedata(User u) {
		
		return di.updatedata(u);
	}



}
