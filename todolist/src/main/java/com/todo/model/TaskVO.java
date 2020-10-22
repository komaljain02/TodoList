package com.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Calendar;

@Entity
@Table(name = "tasktable")
public class TaskVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Tid")
	private int tid;

	@Column(name = "Tasktitle")
	private String title;

	@Column(name = "Taskdata")
	private String taskdata;

	@Column(name = "Priority")
	private int priority;

	@Column(name = "Createdtaskdate")
	private Calendar date;

	@Column(name = "Month")
	private int month;

	@Column(name = "Year")
	private int years=2020;

	@Column(name = "Day")
	private int day;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Column(name = "status")
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "rid")
	private RegVO regvo;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTaskdata() {
		return taskdata;
	}

	public void setTaskdata(String taskdata) {
		this.taskdata = taskdata;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public RegVO getRegvo() {
		return regvo;
	}

	public void setRegvo(RegVO regvo) {
		this.regvo = regvo;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

}
