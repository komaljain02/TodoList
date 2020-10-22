package com.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Userregister")
public class UserVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Uid")
	private int uid;
	
	@Column(name="Email")
	private String mail;
	
	@Column(name="Password")
	private String password;

	@Column(name="Status")
	private boolean status;
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
