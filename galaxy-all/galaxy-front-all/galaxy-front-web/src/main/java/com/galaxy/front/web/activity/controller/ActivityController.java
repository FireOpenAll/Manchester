/**
 * 
 */
package com.galaxy.front.web.activity.controller;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.galaxy.front.web.rest.model.ResultModel;

/**
 * @author luolishu
 * 
 */
@Controller
@RequestMapping(value = "/activity")
public class ActivityController {
	@RequestMapping(value = "/create",method=RequestMethod.GET)
	public String create() {
		return "activity/postactivity";
	}
	@RequestMapping(value = "post",method=RequestMethod.POST)
	public String post() {
		return "activity/postsuccess";
	}
	
	
	@RequestMapping(value = "modify/{id}",method=RequestMethod.GET)
	public String modify(@PathVariable Long id) {
		return "activity/postactivity";
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

	@ResponseBody
	@RequestMapping(value = "/geteventcategory",method = RequestMethod.GET)
	public Object getEventCategory(){
		ResultModel resultModel = new ResultModel();
		ArrayList<testModel> list = new ArrayList<ActivityController.testModel>();
		for (int i = 0; i < 10; i++) {
		list.add(new testModel(i,"分类"+i));
		}
		
		resultModel.setData(list);
		
		return resultModel;
	}

	
	class testModel implements Serializable{
		int id ;
		String name;
		public testModel() {
			super();
		}
		public testModel(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
	}
}
