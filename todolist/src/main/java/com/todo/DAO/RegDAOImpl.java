package com.todo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todo.model.RegVO;

@Repository
public class RegDAOImpl implements RegDAO {

	@Autowired
	private SessionFactory sessionfactory;

	public void insert(RegVO vo) {

		Session session = this.sessionfactory.getCurrentSession();
		session.saveOrUpdate(vo);

	}

	public List<RegVO> search(int uid) {
		List<RegVO> ls = new ArrayList<RegVO>();
		Session session = this.sessionfactory.getCurrentSession();
		Query q = session.createQuery("from RegVO where uv.uid="+uid);
		ls = q.list();
		return ls;
	}
}
