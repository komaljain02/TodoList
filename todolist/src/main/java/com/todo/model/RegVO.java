package com.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="todolistregister")
public class RegVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Rid")
	private int rid;
	
	@Column(name="Fname")
	private String name;
	
	
	@Column(name="Status")
	private boolean status;
	
	@OneToOne
	@JoinColumn(name="Uid")
	private UserVO uv;
	
	
	public UserVO getUv() {
		return uv;
	}

	public void setUv(UserVO uv) {
		this.uv = uv;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
