import org.junit.Test;

import com.google.gson.Gson;

/**
 * 
 */

/**
 * @author luolishu
 *
 */

public class GsonTest {
	@Test
	public void testJson()throws Exception{
		Gson gson=new Gson();
		String json="{\"code\":\"20000\",\"message\":null,\"data\":[]}";
		Result<Person> result2=null;
		Result result=gson.fromJson(json, Result.class);  
	
		System.out.println(result.data.getClass());
		System.out.println(result.code);
		System.out.println(result.message);
	}
   class Person{
	   String age;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	   
   }
	class Result<T>{
		String code;
		String message;
		T data;
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		 
		 
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		
		
	}

}
