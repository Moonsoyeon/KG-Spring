package com.spring.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//자동으로 스프링 컨테이너에 해당 클래스의 빈을 등록하는 아노테이션
@Controller
public class RequestController {
	
	public RequestController() {
		System.out.println("RequestCon 작동");
	}
	
	//RequestMappting은 어떤 URI로 이 메서드를 동작시킬 것인가에 대한 설정입니다.
	@RequestMapping("/request/test")
	public String testCall() {
		System.out.println("/request/test 요청이 들어옴!");
		return "test";
	}
	
	/*
	 만약 /request/req 요청이 들어왔을 때
	 views 폴더 아래에 있는 request폴더 아래에
	 req-ex01.jsp파일을 열도록 메서드를 구성해보세요
	*/
	@RequestMapping("/reques t/req")
	public String req() {
		System.out.println("/request/req 요청이 들어옴!");
		return "request/req-ex01";
	}
	
	//Get방식 전용 메소드
	//@RequestMapping(value = "/request/basic01", method = RequestMethod.GET)
	@GetMapping("/request/basic01")
	public String basicGet() {
		System.out.println("/request/basic01 요청이 들어옴: GET");
		return "request/req-ex01";
	}
	
	//@RequestMapping(value = "/request/basic01", method = RequestMethod.POST)
	@PostMapping("/request/basic01")
	public String basicPost() {
		System.out.println("/request/basic01 요청이 들어옴: POST");
		return "request/req-ex01";
	}
	
	//요청 파라미터 받아보기
	@GetMapping("/request/param")
	public String paramTest(HttpServletRequest request) {
		System.out.println("/request/param 요청: GET");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		return "";
	}
	
}
