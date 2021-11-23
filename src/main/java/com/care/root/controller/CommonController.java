package com.care.root.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@Autowired HttpSession session;	//기본 spring에선 불가능
	
	@GetMapping("/")
	public String index(Model model) {	//spring에선 html에 session,model 사용X
		session.setAttribute("user", "session value");
		model.addAttribute("user","model value");
		return "index";
	}
}
