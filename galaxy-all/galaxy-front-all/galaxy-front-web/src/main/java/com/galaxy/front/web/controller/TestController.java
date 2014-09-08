package com.galaxy.front.web.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class TestController {
	@RequestMapping(value="/test3", method=RequestMethod.GET)
	public String home(){
		return "home";
	}
}
