package com.todo.service;

import java.util.List;

import com.todo.model.RegVO;

public interface RegService {

	public void insert(RegVO vo);
	
	public List<RegVO> search(int uid);

}
