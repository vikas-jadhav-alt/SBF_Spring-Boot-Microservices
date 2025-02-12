package com.nt.rest;

import java.security.Principal;
import java.util.Collection;
import java.util.Random;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOperationsController {

	@GetMapping("/home")
	public String showHome() {
		return " <h1> welcome to home page of  IndiaBus.com </h1>";
	}

	@GetMapping("/balance")
	public String showBalance() {
		int balanceAmount = new Random().nextInt(10000);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		GrantedAuthority next = authorities.iterator().next();
		String authority = next.getAuthority();

		return " <h1> Successfully Logged into  Vikas Bus Service.com :::" + balanceAmount + " String Authority: "
				+ next + "</h1>";
	}

	@GetMapping("/user")
	public Authentication showUserDetails(Principal principle) {
		System.out.println("currently logged FB user name::" + principle.getName());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

//		Root r = (Root) auth;
//		
//		String fullName = r.getPrincipal().getFullName();
//		
//		return "Welcome: " + fullName;

		System.out.println("Name: " + auth.getName());
		System.out.println("Principal: " + auth.getPrincipal());
		return auth;

	}

}
