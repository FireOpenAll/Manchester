/**
 * 
 */
package com.galaxy.front.web.activity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luolishu
 * 
 */
@Controller
@RequestMapping(value = "activity")
public class ActivityDetailController {
	@RequestMapping(value = "detail/{id}.html")
	public String details(@PathVariable Long id) {
		return "activity/detail";
	}

}
