package com.todo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.DAO.UserDAO;
import com.todo.model.RegVO;
import com.todo.model.UserVO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userdao;
	
	@Transactional
	public void insert(UserVO uvo)
	{
		userdao.insert(uvo);
	}
	
	@Transactional
	public List<UserVO> search(UserVO vo)
	{
		return this.userdao.search(vo);
	}
	
	@Transactional
	public List<UserVO> searchUser(UserVO vo)
	{
		return this.userdao.searchUser(vo);
	}
}
