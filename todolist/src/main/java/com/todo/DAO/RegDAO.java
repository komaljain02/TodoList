package com.todo.DAO;

import java.util.List;

import com.todo.model.RegVO;

public interface RegDAO {
	
	public void insert(RegVO vo);
	
	public List<RegVO> search(int uid);
}
