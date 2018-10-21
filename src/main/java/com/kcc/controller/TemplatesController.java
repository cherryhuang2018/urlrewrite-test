package com.kcc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplatesController {

	@GetMapping("/index1")
	public String index1(HttpServletRequest request) {
		request.setAttribute("key", "hello world1111111111111");
		return "/index1";
	} 
	
	@GetMapping("/index2")
	public String index2(HttpServletRequest request) {
		request.setAttribute("key", "hello world2222222222222");
		return "/index2";
	} 

}
