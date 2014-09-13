/**
 * 
 */
package com.galaxy.front.web.activity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author luolishu
 * 
 */
@Controller
@RequestMapping(value = "activity")
public class ActivityController {
	@RequestMapping(value = "post",method=RequestMethod.POST)
	public String post(@PathVariable Long id) {
		return "activity/detail";
	}
	
	
	@RequestMapping(value = "modify",method=RequestMethod.POST)
	public String modify(@PathVariable Long id) {
		return "activity/detail";
	}
	@RequestMapping(value = "remove",method=RequestMethod.GET)
	public String remove(@PathVariable Long id) {
		//check 活动信息属于自己的
		return "activity/detail";
	}
	
	@RequestMapping(value = "modify",method=RequestMethod.GET)
	public String view(@PathVariable Long id) {
		return "activity/detail";
	}


}
