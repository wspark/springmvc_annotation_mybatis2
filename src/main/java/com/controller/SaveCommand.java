package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.biz.user.service.UserServiceImpl;
import com.biz.user.vo.Users;

public class SaveCommand implements Controller  {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView nextPage=new ModelAndView();		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String role=request.getParameter("role");
		
		try{
			new UserServiceImpl().addUser(new Users(id,password,name,role));
			nextPage.addObject("message", "등록되었습니다");
			
			nextPage.setViewName("result");
		}catch(Exception e){
			nextPage.addObject("message",e.getMessage());
		}	
		nextPage.setViewName("result");
		return nextPage;
	}

}
