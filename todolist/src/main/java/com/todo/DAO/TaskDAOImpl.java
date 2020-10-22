package com.todo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todo.model.TaskVO;

@Repository
public class TaskDAOImpl implements TaskDAO{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	public void insertData(TaskVO taskvo)
	{
		Session session = this.sessionfactory.getCurrentSession();
		
		session.saveOrUpdate(taskvo);
	}
	
	public List<TaskVO> retriveAll(int i)
	{			
		Session session = this.sessionfactory.getCurrentSession();
		
		Query q = session.createQuery("from TaskVO as tv where tv.status="+true+" and regvo.rid="+ i);
		
		List<TaskVO> ls = q.list();
		
		System.out.println(ls.size());
		
		 return ls;
	}
	
	public List<TaskVO> retriveInfo(TaskVO tvo)
	{
		Session session = this.sessionfactory.getCurrentSession();
		
		Query q = session.createQuery("from TaskVO where tid="+tvo.getTid());
		
		List<TaskVO> ls = q.list();
		
		return ls;
	}
	
	public List<TaskVO> search(String t,int rid)
	{
		Session session = this.sessionfactory.getCurrentSession();
		
		Query q = session.createQuery("from TaskVO where title='"+t+"' and status="+true+" and regvo.rid="+rid);
		
		List<TaskVO> ls = q.list();
		
		return ls;
		
	}
	
	public List<TaskVO> sortByDate(int rid)
	{
		Session session = this.sessionfactory.getCurrentSession();
		
		Query q = session.createQuery("from TaskVO  where regvo.rid="+rid+" and status="+true+" order by date asc");
		
		List<TaskVO> ls = q.list();
		
		return ls; 
	}
	
	public List<TaskVO> sortByAllPriority(int rid)
	{
		Session session = this.sessionfactory.getCurrentSession();
		
		Query q = session.createQuery("from TaskVO  where regvo.rid="+rid+" and status="+true+" order by priority asc");
		
		List<TaskVO> ls = q.list();
		
		return ls; 
	}
	
	public List<TaskVO> sortByPriority(int p,int rid)
	{
		Session session = this.sessionfactory.getCurrentSession();
		
		Query q = session.createQuery("from TaskVO  where regvo.rid="+rid+" and status="+true+" and priority="+p);
		
		List<TaskVO> ls = q.list();
		
		return ls; 
	}

}
