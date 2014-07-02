package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.biz.user.service.UserServiceImpl;
import com.biz.user.vo.Users;

public class ViewCommand implements Controller {

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView nextPage=new ModelAndView();	
		String id = request.getParameter("id");
		try{
			Users user = new UserServiceImpl().findUser(id);
			
			nextPage.addObject("user", user);
			nextPage.setViewName("view");
		}catch(Exception e){
			request.setAttribute("message", e.getMessage());
			nextPage.setViewName("result");
		}		
		
		return nextPage;
	}

}
