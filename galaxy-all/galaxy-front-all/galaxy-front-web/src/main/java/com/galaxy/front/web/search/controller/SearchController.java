/**
 * 
 */
package com.galaxy.front.web.search.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author luolishu
 *
 */
@Controller
@RequestMapping(value = "search")
public class SearchController {
	
	@RequestMapping(value = "{cat1}/{cat2}")
	public String details(HttpServletRequest request,@PathVariable Long cat1,@PathVariable Long cat2,@RequestParam(value="kw",required=false) String keywords) {
		request.setAttribute("content", "zheshicontent");
		return "search/search";
	}
	
   @RequestMapping(method=RequestMethod.GET)
   public String searchByCategory(HttpServletRequest request){
	   
	   request.setAttribute("content", "searchByCategory");
	   return "search/search";
   }

}
 