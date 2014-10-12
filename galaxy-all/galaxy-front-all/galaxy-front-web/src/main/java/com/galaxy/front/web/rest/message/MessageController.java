package com.galaxy.front.web.rest.message;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.message.broker.MessageBroker;
import com.lepeng.im.message.Message;
import com.lepeng.im.message.json.JsonDecoder;

@RestController(value = "MqttMessageController")
@RequestMapping(value = "api/v1/message")
public class MessageController {
	@Autowired
	MessageBroker messageBroker;

	/**
	 * 发送消息接口
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "send")
	public Object sendMessage(@RequestParam("message") String message) {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		if (message == null) {
			result.setCode("40000");
			return result;
		}
		try {
			Message<?> msg = JsonDecoder.decode(message);
			messageBroker.receive(msg);
		} catch (Exception e) {
			result.setCode("40000");
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
