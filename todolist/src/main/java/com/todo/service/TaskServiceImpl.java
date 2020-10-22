package com.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.DAO.TaskDAO;
import com.todo.model.RegVO;
import com.todo.model.TaskVO;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	public TaskDAO taskdao;
	
	@Transactional
	public void insertData(TaskVO taskvo)
	{
		this.taskdao.insertData(taskvo);
	}
	
	@Transactional
	public List<TaskVO> retriveAll(int i)
	{
		return this.taskdao.retriveAll(i);
	}
	
	@Transactional
	public List<TaskVO> retriveInfo(TaskVO tvo)
	{
		List<TaskVO> ls = this.taskdao.retriveInfo(tvo);
		
		return ls;
	}
	
	@Transactional
	public List<TaskVO> search(String t,int rid)
	{
		return this.taskdao.search(t,rid);
	}
	
	@Transactional
	public List<TaskVO> sortByDate(int rid)
	{
		return this.taskdao.sortByDate(rid);
	}
	
	@Transactional
	public List<TaskVO> sortByAllPriority(int rid)
	{
		return this.taskdao.sortByAllPriority(rid);
	}
	
	@Transactional
	public List<TaskVO> sortByPriority(int p,int rid)
	{
		return this.taskdao.sortByPriority(p,rid);
	}
}
