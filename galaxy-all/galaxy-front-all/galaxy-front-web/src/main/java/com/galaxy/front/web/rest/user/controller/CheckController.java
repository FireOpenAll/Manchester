/**
 * 
 */
package com.galaxy.front.web.rest.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luolishu
 * 
 */
@RestController
@RequestMapping(value = "api/v1/check")
public class CheckController {
	@RequestMapping(value = "email",method=RequestMethod.GET)
	public Object checkEmail(@RequestParam("email")String email) {
		return true;
	}
	@RequestMapping(value = "username",method=RequestMethod.GET)
	public Object checkUser(@RequestParam("member_name")String username) {
		return true;
	}
 
}
