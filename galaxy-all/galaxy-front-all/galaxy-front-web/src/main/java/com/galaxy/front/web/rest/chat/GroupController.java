package com.galaxy.front.web.rest.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.message.broker.MessageBroker;

@RestController(value = "GroupController")
@RequestMapping(value = "api/v1/chat/group")
public class GroupController {
	@Autowired
	MessageBroker messageBroker;

	/**
	 * 加入组
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "join")
	public Object join(@RequestParam("groupId") Long groupId) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		 
		return result;
	}
	/**
	 * 加入组
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "setManager")
	public Object setManager(@RequestParam("userId") Long userId) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		 
		return result;
	}
	/**
	 * 加入组
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "remove")
	public Object remove(@RequestParam("userId") Long userId) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		 
		return result;
	}
 
	/**
	 * 创建群组
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "create")
	public Object create(@RequestParam("groupName") String groupName) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		 
		return result;
	}
	/**
	 * 创建群组
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "members")
	public Object members(@RequestParam("groupId") Long groupId) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		 
		return result;
	}
}
