/**
 * 
 */
package com.galaxy.front.web.activity.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.galaxy.dal.domain.activity.Activity;
import com.galaxy.dal.domain.activity.ActivityType;
import com.galaxy.front.web.activity.controller.PostModel.CreateModel;
import com.galaxy.front.web.activity.controller.PostModel.EvenBaseInfoModel;
import com.galaxy.front.web.activity.controller.PostModel.OrgModel;
import com.galaxy.front.web.activity.controller.PostModel.TicketModel;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.service.activity.ActivityService;
import com.galaxy.service.activity.form.ActivityForm;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/*author:huangshanqi
 *time  :2014年11月5日 上午9:57:49
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	/**
	 * ajax创建活动表单提交第一版
	 */
	@RequestMapping(value = "saveEventBase", method = RequestMethod.POST)
	public String saveEventBase(HttpServletRequest request, HttpServletResponse response) {

		/**
		 * Model:event_ticket_hidden_info, event_base_hidden_info,
		 * event_org_hidden_info,
		 * 
		 * 
		 */

		/*
		 * String event_name ="";//活动名称 String event_start_time = "";// String
		 * event_end_time= "";// String event_address_name= "";// String
		 * event_address_info= "";//详细地址 String img_event_logo_src_te="";//活动图片
		 * 
		 * String org_name= "";//主办方名字 String logo_url= "";//主办方logo String
		 * org_description= "";//主办方介绍
		 * 
		 * String refer_telephone= "";//咨询电话 String description= "";//活动简介
		 * String editor_text= "";//活动详情
		 * 
		 * //上传海报 String eventhaibao_logo1= "";// String eventhaibao_logo2=
		 * "";// String eventhaibao_logo3= "";//
		 * 
		 * //门票list[] String id;//门票id String name;//门票名称 String qty;//总数量
		 * String saleqty;//已售 String price;//价格 String status;//售票状态 String
		 * type;//门票类型(1=免费，2=收费)
		 * 
		 * 
		 * //隐私 String event_yinsi;//(1=公开,2=不公开)
		 * 
		 * 
		 * //活动类型 String event_category1;//(=列表id)
		 * 
		 * //地点 String city_name;// String event_logitude;// String
		 * event_latitude;//
		 */
		
		EvenBaseInfoModel evenBaseInfoModel = null;
		List<TicketModel> ticketModels = null;
		List<OrgModel> orgModels = null;
		ActivityForm activityForm = null;

		StringBuilder sBuilder = new StringBuilder("");

		// 活动详情
		String editor_text_zyc = null;
		editor_text_zyc = request.getParameter("editor_text_zyc");

		//
		String event_base_hidden_info = null;
		event_base_hidden_info = request.getParameter("event_base_hidden_info");
		
		//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!event_base_hidden_info \n"+event_base_hidden_info+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!event_base_hidden_info \n");

		if (event_base_hidden_info != null) {
			Gson gson = new Gson();
			evenBaseInfoModel = gson.fromJson(event_base_hidden_info, EvenBaseInfoModel.class);

			System.out.println("evenBaseInfoModel==" + evenBaseInfoModel.toString());
			sBuilder.append("evenBaseInfoModel==").append(evenBaseInfoModel.toString()).append("\n");

		}

		//
		String event_ticket_hidden_info = null;
		event_ticket_hidden_info = request.getParameter("event_ticket_hidden_info");
		if (event_ticket_hidden_info != null) {
			Gson gson = new Gson();
			ticketModels = gson.fromJson(event_ticket_hidden_info, new TypeToken<List<TicketModel>>() {
			}.getType());

			System.out.println("ticketModels" + ticketModels.toString());
			sBuilder.append("ticketModels==").append(ticketModels.toString()).append("\n");
			// Gson gson = new Gson();
			// Event_ticket_hidden_info_JsonModel
			// event_ticket_hidden_info_JsonModel =
			// gson.fromJson(event_ticket_hidden_info,
			// Event_ticket_hidden_info_JsonModel.class);
			// System.out.println("event_ticket_hidden_info_JsonModel.getList().get(0).getName()=="+event_ticket_hidden_info_JsonModel.getList().get(0).getName());
		}

		//
		String event_org_hidden_info = null;
		event_org_hidden_info = request.getParameter("event_org_hidden_info");
		if (event_org_hidden_info != null) {
			Gson gson = new Gson();
			orgModels = gson.fromJson(event_org_hidden_info, new TypeToken<List<OrgModel>>() {
			}.getType());
			System.out.println("orgModels==" + orgModels.toString());
			sBuilder.append("orgModels==").append(orgModels.toString()).append("\n");
		}

		if (evenBaseInfoModel != null && ticketModels != null && orgModels != null && editor_text_zyc != null) {
			activityForm = new ActivityForm();
			activityForm.setTitle(evenBaseInfoModel.getEvent_name());
			activityForm.setStartTime(String2Date(evenBaseInfoModel.getEvent_start_time()));
			activityForm.setEndTime(String2Date(evenBaseInfoModel.getEvent_end_time()));

			activityForm.setAddress(evenBaseInfoModel.getEvent_address_info());
			activityForm.setLongtitude(evenBaseInfoModel.getEvent_longitude());
			activityForm.setLatitude(evenBaseInfoModel.getEvent_latitude());
			activityForm.setPhone(evenBaseInfoModel.getRefer_telephone());
			activityForm.setDescription(evenBaseInfoModel.getDescription());
			activityForm.setContent(editor_text_zyc);// 详情

			activityForm.setHaibao_urls(evenBaseInfoModel.getHaibao_urls());

			activityForm.setCatId1(Long.valueOf(evenBaseInfoModel.getEvent_category1()));

			activityForm.setType((evenBaseInfoModel.getEvent_yinsi() % 2 == 0) ? ActivityType.ONLINE
					: ActivityType.OFFLINE);

			activityService.create(activityForm);

		}

		request.setAttribute("parameters", sBuilder.toString());

		return "activity/postsuccess";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "activity/create";
	}
	
	//活动提交第二版
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createPost(HttpServletRequest request,@ModelAttribute("form") CreateModel model,
			@RequestParam("haibao1")MultipartFile haibao1File,@RequestParam("haibao2")MultipartFile haibao2File,
			@RequestParam("haibao3")MultipartFile haibao3File) {
		/*
		StringBuilder sb= new StringBuilder();
		Set<String> paramsSet = request.getParameterMap().keySet();
		for (String key:paramsSet) {
			sb.append(key).append("=").append(request.getParameter(key)).append(",");
		}
		System.err.println("all string = "+sb.toString());
		*/
		if (haibao1File == null) {
			System.out.println("haobao1 is null``````````````````````````````````````````");
		}
		
		System.out.println("name====================================!!!!!!!!!!!!!!!!!"+model.getName());
		System.out.println("haobaos=================================!!!!!!!!!!!!!!!!!"+haibao1File.getName());
		
		ActivityForm activityForm = new ActivityForm();
		
		LoginUserModel loginUserModel = UserUtils.getLoginUser();
		long userId = loginUserModel.getUserId();
		System.out.println("userId============================="+userId);
		//保存海报
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
		String fold = simpleDateFormat.format(new Date());
		String haibao_urls_path = "/upload/images/activity/"+userId+"/"+fold+"/";
		System.out.println("haobao1="+haibao1File.getOriginalFilename()+":"+haibao1File.getName());
		System.out.println("haobao2="+haibao2File.getOriginalFilename()+":"+haibao2File.getName());
		System.out.println("haobao3="+haibao3File.getOriginalFilename()+":"+haibao3File.getName());
		String  filename1=(new Date().getTime()+1)+haibao1File.getOriginalFilename().substring(haibao1File.getOriginalFilename().indexOf("."));
		String  filename2=(new Date().getTime()+2)+haibao2File.getOriginalFilename().substring(haibao2File.getOriginalFilename().indexOf("."));
		String  filename3=(new Date().getTime()+3)+haibao3File.getOriginalFilename().substring(haibao3File.getOriginalFilename().indexOf("."));
		
		File targetFile1 = new File(haibao_urls_path, filename1);
		if (!targetFile1.exists()) {
			targetFile1.mkdirs();
		}
		File targetFile2 = new File(haibao_urls_path, filename2);
		if (!targetFile2.exists()) {
			targetFile2.mkdirs();
		}
		File targetFile3 = new File(haibao_urls_path, filename3);
		if (!targetFile3.exists()) {
			targetFile3.mkdirs();
		}
		
		try {
			haibao1File.transferTo(targetFile1);
			haibao2File.transferTo(targetFile2);
			haibao3File.transferTo(targetFile3);
			
			String haibao_urls ="/activity/"+userId+"/"+fold+"/"+filename1+";"+
					"/activity/"+userId+"/"+fold+"/"+filename2+";"+
					"/activity/"+userId+"/"+fold+"/"+filename3;
			System.out.println("haibao_urls======="+haibao_urls);
			activityForm.setHaibao_urls(haibao_urls);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//保存海报
		
		
		activityForm.setUserId(userId);
		activityForm.setType((model.getOptionsRadios()==1)?ActivityType.ONLINE:ActivityType.OFFLINE);
		activityForm.setCatId1(model.getCatId1());
		activityForm.setCatId2(model.getCatId2());
		activityForm.setTitle(model.getName());
		activityForm.setStartTime(String2Date(model.getStart_time()));
		activityForm.setEndTime(String2Date(model.getEnd_time()));
		activityForm.setProvinceId(model.getProvince());
		activityForm.setCityId(model.getCity());
		activityForm.setDistrictId(model.getDistrict());
		activityForm.setAddress(model.getAddress_detail());
		activityForm.setLongtitude(model.getLongtitude());
		activityForm.setLatitude(model.getLatitude());
		activityForm.setPrice(model.getTicket_price());
		activityForm.setTicketsNum(model.getTicket_num());
		activityForm.setPhone(model.getPhone());
		activityForm.setTags(model.getTags());
		activityForm.setDescription(model.getDescription().trim());
		activityForm.setContent(model.getDetail().trim());
		activityForm.setSponsor(model.getSponsor());
		
		activityForm.setJoinedNum(0);
		activityForm.setLiked_num(0);
		
		activityService.create(activityForm);
		request.setAttribute("message", "创建活动成功");
		return "activity/postsuccess";
	}

	@RequestMapping(value = "post", method = RequestMethod.POST)
	public String post() {
		return "activity/postsuccess";
	}

	@RequestMapping(value = "modify/{id}", method = RequestMethod.GET)
	public String modify(@PathVariable Long id) {
		return "activity/postactivity";
	}

	@ResponseBody
	@RequestMapping(value = "get",method = RequestMethod.GET,params="id")
	public Object getActById(@RequestParam("id") Long id){
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("get activity success");
		
		Activity acviActivity = activityService.getActivity(id);
		resultModel.setData(acviActivity);
		return resultModel;
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.GET)
	public String remove(@PathVariable Long id) {
		// check 活动信息属于自己的
		return "activity/detail";
	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String view(@PathVariable Long id) {
		return "activity/detail";
	}

	@ResponseBody
	@RequestMapping(value = "/geteventcategory", method = RequestMethod.GET)
	public Object getEventCategory() {
		ResultModel resultModel = new ResultModel();
		ArrayList<testModel> list = new ArrayList<ActivityController.testModel>();
		for (int i = 0; i < 10; i++) {
			list.add(new testModel(i, "分类" + i));
		}
        resultModel.setCode("20000");
        resultModel.setMessage("geteventcategory success");
		resultModel.setData(list);

		return resultModel;
	}

	class testModel implements Serializable {
		int id;
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

	public Date String2Date(String date) {
		Date date2 = null;
		try {
			date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date2;
	}

	/*
	@Test
	public void test(){
		SimpleDateFormat CeshiFmt2=new SimpleDateFormat("yyyyMMddHHmm");
		System.out.println(CeshiFmt2.format(new Date()));
		System.out.println(new Date().getTime());
		System.out.println(new Date().getTime());
	}
	*/
}
