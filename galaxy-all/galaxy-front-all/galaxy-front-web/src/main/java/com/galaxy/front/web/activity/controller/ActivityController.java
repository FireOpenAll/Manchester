/**
 * 
 */
package com.galaxy.front.web.activity.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	


	/**
	 * ajax创建活动表单提交
	 */
	@RequestMapping(value = "saveEventBase",method = RequestMethod.POST)
	public String saveEventBase(HttpServletRequest request,HttpServletResponse response){
		
		/**
		 * Model:event_ticket_hidden_info
		 * 
		 */
		
		/*
		String event_name ="";//活动名称
		String event_start_time = "";//
		String event_end_time= "";//
		String event_address_name= "";//
		String event_address_info= "";//详细地址
		String img_event_logo_src_te="";//活动图片
		
		String org_name= "";//主办方名字
		String logo_url= "";//主办方logo
		String org_description= "";//主办方介绍
		
		String refer_telephone= "";//咨询电话
		String description= "";//活动简介
		String editor_text= "";//活动详情
		
		//上传海报
		String eventhaibao_logo1= "";//
		String eventhaibao_logo2= "";//
		String eventhaibao_logo3= "";//
		
		//门票list[]
		String id;//门票id
		String name;//门票名称
		String qty;//总数量
		String saleqty;//已售
		String price;//价格
		String status;//售票状态
		String type;//门票类型(1=免费，2=收费)
		
		
		//隐私
		String event_yinsi;//(1=公开,2=不公开)
		
		
		//活动类型
		String event_category1;//(=列表id)
		
		//地点
		String city_name;//
		String event_logitude;//
		String event_latitude;//
		*/
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String event_base_hidden_info = "++++++++++++++++++++++++++++++++++++++++++++";
		event_base_hidden_info = request.getParameter("event_base_hidden_info");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		
		StringBuilder sBuilder = new StringBuilder("");
		Map<String, String[]> map = request.getParameterMap();
		for(String name:map.keySet()){
			System.out.print("key="+name);
			sBuilder.append("key="+name);
			for(String value:map.get(name)){
				sBuilder.append(",value="+value);
				System.out.print(",value="+value);
			}
			sBuilder.append("\n");
			System.out.print("\n");
		}
			
		request.setAttribute("parameters", sBuilder.toString());
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		
		
		
		/*
		String body = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = null;
	    InputStream inputStream;
		try {
			inputStream = request.getInputStream();
			if (inputStream != null) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if (bufferedReader != null){
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	    
        request.setAttribute("parameters", stringBuilder.toString());
        */
        
		return "activity/postsuccess";
	} 
	
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
