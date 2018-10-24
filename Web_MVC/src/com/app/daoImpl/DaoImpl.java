package com.app.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.daoI.DaoI;
import com.app.model.User;
@Repository
public class DaoImpl implements DaoI {
@Autowired
SessionFactory sf;

	@Override
	public int saveUser(User u) {
	
		Session session=sf.openSession();
		int id=(int) session.save(u);
		return id ;
	}

	@Override
	public List<User> saveAllData() {
		Session session=sf.openSession();
		Query< User> q=session.createQuery("from User");
		List<User> ul=q.getResultList();
		return ul;
	}
	@Override
	public List<User> loginUser(String uname, String pass) {
		Session session=sf.openSession();
		Query< User> q=session.createQuery("from User u where u.uname='"+uname+"' and u.pass='"+pass+"'");
		List<User> ul=q.getResultList();
		if(!ul.isEmpty()){
			List<User> ul1=saveAllData();
			return ul1;
		}
		return ul;
	}
	@Override
	public List<User> deleteUser(int id) {
		Session session=sf.openSession();
	    User u=session.get(User.class, id);
	    session.delete(u);
	    session.beginTransaction().commit();
	    List<User> ul1=saveAllData();
		return ul1;
	
	}
	@Override
	public User editData(int id) {
		System.out.println("in daoimpl");
		Session session=sf.openSession();
		User u=session.get(User.class, id);
		session.beginTransaction().commit();
       return u;
	}

	@Override
	public List<User> updatedata(User u) {
		Session session=sf.openSession();
		session.beginTransaction();
		session.update(u);
		session.getTransaction().commit();
		List<User>ul=saveAllData();
		return ul;
	}


}
