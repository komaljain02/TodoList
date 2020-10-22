package com.todo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.DAO.RegDAO;
import com.todo.model.RegVO;

@Service
public class RegServiceImpl implements RegService {
	
	@Autowired
	private RegDAO regdao;
	
	@Transactional
	public void insert(RegVO vo)
	{
		this.regdao.insert(vo);
	}
	
	@Transactional
	public List<RegVO> search(int uid)
	{
		return this.regdao.search(uid);
	}
	
	
	
}
