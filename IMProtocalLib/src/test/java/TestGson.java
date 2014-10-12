import org.junit.Test;

import com.google.gson.Gson;
import com.lepeng.im.message.Message;
import com.lepeng.im.message.json.JsonGroupMessage;
import com.lepeng.im.message.json.JsonDecoder;

public class TestGson {
	@Test
	public void test() {
	
		Gson gson=new Gson();
		JsonGroupMessage group=new JsonGroupMessage();
		group.setContent("Helllo world!");
		group.setId(1L);
		group.setMessageType(2);
		//group.setFromId(111L);
		group.setGroupId(555L);
		String json=gson.toJson(group); 
		group=new JsonGroupMessage();
		System.out.println(json); 
		group.decode(json);
		System.out.println(group); 
	}
	
	@Test
	public void testDecoderGroup() {
	
		Gson gson=new Gson();
		JsonGroupMessage group=new JsonGroupMessage();
		group.setContent("Helllo world!");
		group.setId(1L);
		group.setMessageType(2);
		//group.setFromId(111L);
		group.setGroupId(555L);
		String json=gson.toJson(group); 
		group=new JsonGroupMessage();
		System.out.println(json); 
		Message<?> message=JsonDecoder.decode(json);
		System.out.println(message); 
	}
	
	
}
