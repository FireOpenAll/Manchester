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
@RequestMapping(value = "api/v1/checkcode")
public class CheckCodeController {
	@RequestMapping(value = "verify",method=RequestMethod.GET)
	public Object check(String email) {
		return true;
	}

	@RequestMapping(value = "verify",method=RequestMethod.POST)
	public Object doCheck(@RequestParam("captcha")String code) {
		return true;
	}
}
