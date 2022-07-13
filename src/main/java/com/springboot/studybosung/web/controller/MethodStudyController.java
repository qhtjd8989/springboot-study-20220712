package com.springboot.studybosung.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MethodStudyController {
	 
	@GetMapping({"/", "/index"})
	public String getMethod() {
		return "method/get"; //경로 
	}
	
	@GetMapping("/test") // 요청주소(get요청)
	public String getMethod2() {
		return "method/test";
	}
}
