package com.galaxy.front.web.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*author:huangshanqi
 *time  :2014年11月12日 下午7:22:44
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "/user")
public class MyhomeController {

	@RequestMapping(value = "index",method = RequestMethod.GET)
	public String index(){
		String result = "/user/myhome";
		
		
		return result;
		
	}
}
