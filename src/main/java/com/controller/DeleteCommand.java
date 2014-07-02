package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.biz.user.service.UserServiceImpl;

public class DeleteCommand implements Controller {

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView nextPage=new ModelAndView();
		String id = request.getParameter("id");
		
		try{			
			new UserServiceImpl().deleteUser(id);
			nextPage.addObject("message", "삭제성공");			
			
		}catch(Exception e){
			nextPage.addObject("message",e.getMessage());
		
		}
		nextPage.setViewName("result");
		return nextPage;
	}

}
