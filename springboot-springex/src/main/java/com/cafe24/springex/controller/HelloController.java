package com.cafe24.springex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("email","a@b.c");
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
	
	@RequestMapping("/hello3")
	public String hello3(Model model) {
		model.addAttribute("email", "dooly@gmail.com");
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello4")
	public String hello4(Model model, 
			@RequestParam("email") String email,
			String name 
			/* annotation value 생략시 변수이름으로 값을 찾는다.*/) {
		
		model.addAttribute("email", email);
		System.out.println(name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	
	// 기술침투 (servlet), 비추
	@RequestMapping("/hello5")
	public String hello5(Model model, HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		model.addAttribute("email", email);
		System.out.println(name);
		return "/WEB-INF/views/hello.jsp";
	}
}
