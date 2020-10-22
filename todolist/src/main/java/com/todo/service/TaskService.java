package com.todo.service;

import java.util.List;

import com.todo.model.TaskVO;

public interface TaskService {
	
	public void insertData(TaskVO taskvo);
	
	public List<TaskVO> retriveAll(int i);
	
	public List<TaskVO> retriveInfo(TaskVO tvo);

	public List<TaskVO> search(String t,int rid);
	
	public List<TaskVO> sortByDate(int rid);
	
	public List<TaskVO> sortByAllPriority(int rid);
	
	public List<TaskVO> sortByPriority(int p,int rid);

}
