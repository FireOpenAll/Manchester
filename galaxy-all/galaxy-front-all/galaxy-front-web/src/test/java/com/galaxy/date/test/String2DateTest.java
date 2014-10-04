package com.galaxy.date.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/*author:huangshanqi
 *time  :2014年10月3日 下午8:39:18
 *email :hsqmobile@gmail.com
 */
public class String2DateTest {

	@Test
	public void translateStr2Date() throws ParseException{
		String str = "2014-10-14 20:34";
		
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		 Date date =simpleDateFormat.parse(str);
		 System.out.println(":"+date);
	}
}
