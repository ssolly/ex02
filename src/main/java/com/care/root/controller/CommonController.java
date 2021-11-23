package com.care.root.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.care.root.dto.TestDTO;

@Controller
public class CommonController {

	@Autowired HttpSession session;	//기본 spring에선 불가능
	
	@GetMapping("/")
	public String index(Model model) {	//spring에선 html에 session,model 사용X
		session.setAttribute("user", "session value");
		model.addAttribute("user","model value");
		return "index";
	}
	
	@GetMapping("object")
	public String object(Model model) {
		TestDTO dto01 = new TestDTO();
		TestDTO dto02 = new TestDTO();
		dto01.setName("홍길동-01");
		dto01.setAddr("산골짜기-01");
		dto02.setName("홍길동-02");
		dto02.setAddr("산골짜기-02");
		
		session.setAttribute("user", dto01);
		model.addAttribute("user",dto02);
		
		//spring에선 불가능
		String message = "<script>alert('문제발생');</script>";
		message += "<h3>코드 추가</h3>";
		model.addAttribute("msg",message);
		
		return "object";
	}
	
	
}
