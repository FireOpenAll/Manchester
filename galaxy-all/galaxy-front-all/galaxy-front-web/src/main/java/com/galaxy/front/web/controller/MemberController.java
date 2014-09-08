package com.galaxy.front.web.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class MemberController {
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	public String home2(){
		return "home";
	}
	 
}
