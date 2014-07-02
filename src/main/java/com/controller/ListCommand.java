package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.biz.user.service.UserServiceImpl;
import com.biz.user.vo.Users;

public class ListCommand implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView nextPage=new ModelAndView();
		ArrayList<Users> userList = new UserServiceImpl().findUsers();
		nextPage.addObject("userList", userList);
		nextPage.setViewName("list");	
		
		return nextPage;		
	}

}
