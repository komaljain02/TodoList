package com.todo.DAO;

import java.util.List;

import com.todo.model.UserVO;

public interface UserDAO {
	
	public void insert(UserVO uvo);

	public List<UserVO> search(UserVO vo);

	public List<UserVO> searchUser(UserVO vo);
	
}
