package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.biz.user.service.UserServiceImpl;
import com.biz.user.vo.Users;

public class UpdateCommand implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView nextPage=new ModelAndView();		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String role=request.getParameter("role");
		
		try{
		new UserServiceImpl().updateUser(new Users(id,password,name,role));
		nextPage.addObject("message","수정성공");
		
		}catch(Exception e){
			nextPage.addObject("message",e.getMessage());
		}
		nextPage.setViewName("result");
		return nextPage;
	}

}
