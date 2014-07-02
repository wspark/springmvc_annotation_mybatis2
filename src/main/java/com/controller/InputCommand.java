package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InputCommand implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView nextPage = new ModelAndView();
		nextPage.setViewName("input");	
		//System.out.println("this is Inputcommand");
		return nextPage;
	}

}
