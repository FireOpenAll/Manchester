package com.galaxy.json.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test; 

import com.galaxy.front.web.activity.controller.PostModel.EvenBaseInfoModel;
import com.google.gson.Gson;

/*author:huangshanqi
 *time  :2014年10月3日 上午11:45:20
 *email :hsqmobile@gmail.com
 */
public class TestGson {
	@Test
	public void testParse() throws Exception{
		InputStream stream=TestGson.class.getResourceAsStream("json.txt");
		String content=IOUtils.toString(stream);
		System.out.println(content);
		Gson gson=new Gson();
		EvenBaseInfoModel result=gson.fromJson(content, EvenBaseInfoModel.class);
		
		
	}

}
