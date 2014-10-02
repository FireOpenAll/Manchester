/**
 * 
 */
package com.galaxy.front.web.rest.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luolishu
 * 
 */
@RestController
@RequestMapping(value = "api/v1/email")
public class EmailCheckController {
	@RequestMapping(value = "check")
	public Object check(String email) {
		return false;
	}

}
