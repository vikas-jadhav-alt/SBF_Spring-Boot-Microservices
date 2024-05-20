package com.demo.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@PostMapping(path = "/error")
	public String getStudent() {
		return "Get /Error Is Called";
	}
	
//	@GetMapping(path = "/")
//	public String mainMethod() {
//		return "Forward / Main Controller Called: Not Static One";
//	}

}