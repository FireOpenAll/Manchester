package com.galaxy.front.web.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class TestController {
	@RequestMapping(value="/test3", method=RequestMethod.GET)
	public String test3(){
		return "test3";
	}
	@RequestMapping(value="/test4", method=RequestMethod.GET)
	public String test4(){
		return "test4";
	}
	@RequestMapping(value="/test5", method=RequestMethod.GET)
	public String test5(){
		return "test5";
	}
	@RequestMapping(value="/test6", method=RequestMethod.GET)
	public String test6(){
		return "test6";
	}
	@RequestMapping(value="/test7", method=RequestMethod.GET)
	public String test7(){
		return "test7";
	}
}
