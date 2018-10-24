package com.app.daoI;

import java.util.List;

import com.app.model.User;

public interface DaoI {
	
	int saveUser(User u);

	List<User> loginUser(String uname, String pass);
	
	List<User> deleteUser(int id);

	User editData(int id);

	List<User> saveAllData();


	List<User> updatedata(User u);


	 

}
