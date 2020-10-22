package com.todo.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.todo.model.RegVO;
import com.todo.model.TaskVO;
import com.todo.model.UserVO;
import com.todo.service.RegService;
import com.todo.service.TaskService;
import com.todo.service.UserService;

import java.time.LocalTime;
import java.util.*;

@Controller
public class ListController {
		
	@Autowired
	private RegService regservice;
	
	@Autowired
	private TaskService tasservice;
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/")
	public ModelAndView homePage()
	{
		return new ModelAndView("home","key",new RegVO());
	}
	
	@RequestMapping(value="addtask")
	public ModelAndView addtaskPage()
	{
		return new ModelAndView("addyourtask","tasklist",new TaskVO());
	}
	
	@RequestMapping(value="aboutme",method=RequestMethod.GET)
	public ModelAndView displayAboutme()
	{
		return new ModelAndView("aboutme");
	}
	
	@RequestMapping(value="reset",method=RequestMethod.GET)
	public ModelAndView resetPage()
	{
		return new ModelAndView("resetpage","userkey",new UserVO());
	}
	
	@RequestMapping(value="titlecompare",method=RequestMethod.GET)
	public ModelAndView titleCheck(@RequestParam String t,@RequestParam int rid,@RequestParam String ti)
	{

		List<TaskVO> ls = new ArrayList();
		if(t.equals("search"))
		{
			ls = this.tasservice.search(ti,rid); 
		}
		else if(t.equals("4"))
		{
			ls = this.tasservice.sortByDate(rid);
		}
		else if(t.equals("5"))
		{
			ls = this.tasservice.sortByAllPriority(rid);
		}
		else if(t.equals("1"))
		{
			ls = this.tasservice.sortByPriority(Integer.parseInt(t),rid);
		}

		else if(t.equals("2"))
		{
			ls = this.tasservice.sortByPriority(Integer.parseInt(t),rid);
		}

		else if(t.equals("3"))
		{
			ls = this.tasservice.sortByPriority(Integer.parseInt(t),rid);
		}
		return new ModelAndView("json1","tasklist",ls);
	}
	
	@RequestMapping(value="resetpassword",method=RequestMethod.GET)
	public ModelAndView resetPage(@ModelAttribute UserVO uv)
	{
		
		this.userservice.insert(uv);
		return new ModelAndView("home","key",new RegVO());
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute RegVO obj)
	{
		obj.getUv().setStatus(true);
		this.userservice.insert(obj.getUv());
		obj.setStatus(true);
		this.regservice.insert(obj);
		return new ModelAndView("home","key",new RegVO());
	}
	
	//"@"RequestParam is url decoded that means no need to decode value of query string 
	//"@"RequestParam only reads query string
	@RequestMapping(value="verify",method=RequestMethod.GET)
	public ModelAndView validateUser(@RequestParam String a,@RequestParam String b,HttpServletRequest request)
	{
		UserVO obj = new UserVO();
		System.out.println(a+" ,"+b);
		obj.setMail(a);
		obj.setPassword(b);
		List<UserVO> ls = this.userservice.search(obj);
		if(ls.size()!=0)
		{
			HttpSession se = request.getSession();
			List<RegVO> ls1 = this.regservice.search(ls.get(0).getUid());
			se.setAttribute("user",ls1.get(0).getName());
			se.setAttribute("id",ls1.get(0).getRid());
		}
		return new ModelAndView("json","data",ls.size());
	}
	
	@RequestMapping(value="insertdata",method=RequestMethod.POST)
	public ModelAndView insertData(@ModelAttribute TaskVO tk)
	{
		
		tk.setStatus(true);
		LocalTime lt = LocalTime.now();
		Calendar c = Calendar.getInstance();
		c.set(tk.getYears(),tk.getMonth()-1,tk.getDay(),lt.getHour(),lt.getMinute(),lt.getSecond());
		tk.setDate(c);
		this.tasservice.insertData(tk);
		return new ModelAndView("addyourtask","tasklist",new TaskVO());
	}
	
	@RequestMapping(value="mytask",method=RequestMethod.GET)
	public ModelAndView displayList(@RequestParam int i)
	{
		
		List<TaskVO> ls =  this.tasservice.retriveAll(i);
		System.out.println(ls.size());
		return new ModelAndView("listtask","listdata",ls);
	}
	
	@RequestMapping(value="deletedata",method=RequestMethod.GET)
	public ModelAndView deleteTask(@RequestParam int id,@RequestParam int i,Model model)
	{
		
		TaskVO obj = new TaskVO();
		obj.setTid(id);
		List<TaskVO> ls =  this.tasservice.retriveInfo(obj);
		obj = (TaskVO)ls.get(0);
		obj.setStatus(false);
		this.tasservice.insertData(obj);
		model.addAttribute("id",i);
		ls =  this.tasservice.retriveAll(i);
		return new ModelAndView("listtask","listdata",ls);
	}
	
	@RequestMapping(value="editdata",method=RequestMethod.GET)
	public ModelAndView editTask(@RequestParam int id)
	{
		TaskVO obj = new TaskVO();
		obj.setTid(id);
		List<TaskVO> ls =  this.tasservice.retriveInfo(obj);
		return new ModelAndView("addyourtask","tasklist",(TaskVO)ls.get(0));
	}
	
}
