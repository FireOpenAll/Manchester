package com.galaxy.front.web.rest.chat;

import java.io.Serializable;
import java.util.Collections;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.user.User;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.service.user.UserService;

@RestController(value = "ChatMemberController")
@RequestMapping(value = "api/v1/chat/")
public class MemberController {
	static Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	UserService userService;

	@RequestMapping(value = "member")
	public Object memberInfo(@RequestParam("id") Long memberId) {
		User user = userService.getUserById(memberId);
		if (user == null) {
			return Collections.EMPTY_MAP;
		}
		ChatMemberModel model=new ChatMemberModel();
        model.setAvatar(user.getAvatar());
        model.setGender(""+user.getGender());
        String name=user.getLoginName();
        if(StringUtils.isBlank(name)){
        	name=user.getNick();
        }
        if(StringUtils.isBlank(name)){
        	name=user.getEmail();
        }
        model.setName(user.getLoginName());
        model.setUserId(user.getId());
        ResultModel result = new ResultModel();
		result.setCode("20000");
		result.setData(model);
		return result;
	}

	public static class ChatMemberModel implements Serializable {
		Long userId;
		String name;
		String avatar;
		String gender;
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAvatar() {
			return avatar;
		}
		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		
		
		

	}

}
