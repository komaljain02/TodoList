package com.todo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todo.model.RegVO;
import com.todo.model.UserVO;

@Repository
public class UserDAOImpl implements  UserDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	public void insert(UserVO uvo)
	{
		Session session = this.sessionfactory.getCurrentSession();
		
		session.saveOrUpdate(uvo);
	}
	
	public List<UserVO> search(UserVO vo) {
		List<UserVO> ls = new ArrayList<UserVO>();
		Session session = this.sessionfactory.getCurrentSession();
		String query="from UserVO where password=:x and mail=:y";
		Query q = session.createQuery(query);
		q.setParameter("y",vo.getMail());
		q.setParameter("x",vo.getPassword());
		ls = q.list();
		return ls;
	}
	
	public List<UserVO> searchUser(UserVO vo) {
		List<UserVO> ls = new ArrayList<UserVO>();
		Session session = this.sessionfactory.getCurrentSession();
		Query q = session.createQuery("from UserVO where mail="+vo.getMail());
		ls = q.list();
		return ls;
	}

}
