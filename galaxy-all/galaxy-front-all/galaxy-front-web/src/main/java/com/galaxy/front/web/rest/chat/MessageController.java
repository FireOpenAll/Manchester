package com.galaxy.front.web.rest.chat;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.PaginationParam;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.message.broker.MessageBroker;
import com.galaxy.message.service.ChatQueryService;
import com.lepeng.im.message.Message;
import com.lepeng.im.message.json.JsonDecoder;

@RestController(value = "MqttMessageController")
@RequestMapping(value = "api/v1/chat")
public class MessageController {
	static Logger logger=LoggerFactory.getLogger(MessageController.class);
	@Autowired
	MessageBroker messageBroker;
	@Autowired
	ChatQueryService chatQueryService;

	/**
	 * 发送消息接口
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "send",method=RequestMethod.GET)
	public Object sendMessage(@RequestParam("message") String message) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		result.setData((Serializable) Collections.EMPTY_MAP);
		if (message == null) {
			result.setCode("40000");
			return result;
		}
		try {
			Message<?> msg = JsonDecoder.decode(message);
			messageBroker.receive(msg);
		} catch (Exception e) {
			result.setCode("40000");
			logger.error("decode error!",e);
		}
		return result;
	}
	/**
	 * 发送消息接口
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "messageList",method=RequestMethod.GET)
	public Object messageList(@RequestParam("fromId") Long fromId,@RequestParam("toId") Long toId,@RequestParam(value="utilId",required=false) Long utilId) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		result.setData((Serializable) Collections.EMPTY_MAP);
		if(fromId==null||toId==null){
			result.setCode("40000");
			result.setMessage("parameter error!fromId="+fromId+",toId="+toId);
			return result;
		}
		PaginationParam pageParam=new PaginationParam();
		pageParam.setUtilId(utilId);
		List<Message<?>> messageList=chatQueryService.listMessage(fromId, toId, pageParam);
		result.setData((Serializable) messageList);
		return result;
	}
	/**
	 * 发送消息接口
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "groupMessageList",method=RequestMethod.GET)
	public Object groupMessageList(@RequestParam("groupId") Long groupId,@RequestParam(value="utilId",required=false) Long utilId) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		result.setData((Serializable) Collections.EMPTY_MAP);
		if(groupId==null){
			result.setCode("40000");
			result.setMessage("parameter error!groupId="+groupId);
			return result;
		}
		PaginationParam pageParam=new PaginationParam();
		pageParam.setUtilId(utilId);
		List<Message<?>> messageList=chatQueryService.listGroupMessage(groupId, pageParam);
		result.setData((Serializable) messageList);
		return result;
	}
	/**
	 * 发送消息接口
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "send",method=RequestMethod.POST)
	public Object sendMessagePost(@RequestBody Map<?,?> message) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		result.setData((Serializable) Collections.EMPTY_MAP);
		if (message == null) {
			result.setCode("40000");
			return result;
		}
		try {
			Message<?> msg = JsonDecoder.decode(message);
			messageBroker.receive(msg);
		} catch (Exception e) {
			result.setCode("40000");
			logger.error("decode error!",e);
		}
		return result;
	}

	/**
	 * token请求获取服务器连接信息，方便服务端扩展 String ip="182.92.169.209"; String port="1883";
	 * String token;
	 * 
	 * @return
	 */
	@RequestMapping(value = "token")
	public Object token() {
		Token token = new Token();
		ResultModel result = new ResultModel();
		result.setCode("20000");
		result.setData(token);
		return result;
	}

	/**
	 * heartbeat 检测，保持登录状态
	 * 
	 * @return
	 */
	@RequestMapping(value = "ping")
	public Object ping() {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		return result;
	}

	public Object groupMembers() {
		return null;
	}

	public Object removeMessage() {
		return null;
	}

	public Object updateMessageRead() {
		return null;
	}

	public class Token implements Serializable {
		String ip = "182.92.169.209";
		String port = "1883";
		String token;

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

	}

}
