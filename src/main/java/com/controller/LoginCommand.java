package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.biz.user.service.UserServiceImpl;

public class LoginCommand implements Controller {

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView nextPage=new ModelAndView();
		//date check
		String id = request.getParameter("id");
		String password = request.getParameter("password");
			
		//business method call
		boolean isExist = false;
	
			try {
				isExist = (boolean)new UserServiceImpl().login(id, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("isExist = "  + isExist);
	
		if(isExist){
			//session 생성
			HttpSession session=request.getSession();
			session.setAttribute("id",id);
			nextPage.addObject("login", id);
			nextPage.addObject("message",id+"님 반갑습니다.");
			//view select
			nextPage.setViewName("result");
		}else{
			nextPage.setViewName("login");
		}
		return nextPage;		
	}

}
