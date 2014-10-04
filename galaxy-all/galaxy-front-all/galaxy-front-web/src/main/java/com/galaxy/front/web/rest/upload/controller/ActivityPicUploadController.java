package com.galaxy.front.web.rest.upload.controller;

import java.io.File;
import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.galaxy.front.web.rest.model.ResultModel;
import com.mysql.fabric.xmlrpc.base.Param;

@Controller
@RequestMapping(value = "/activity")
public class ActivityPicUploadController {

	@ResponseBody
	@RequestMapping(value = "ajax_picture_upload")
	//public Object activityPicUpload( @RequestParam("event_pic") MultipartFile file,HttpServletRequest request) {
	public Object activityPicUpload(@RequestParam("file_field") String fileParamter,HttpServletRequest request) {

		
		/**
		 * 上传照片
		 * @params : 
		 * dir：存放目录
		 * source=ajaxuploader，说明这是ajaxuploader上传
		 * @return :json
		 */
		
		//thumb_config
		
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		 /**页面控件的文件流**/
        MultipartFile file = multipartRequest.getFile(fileParamter);	    
        System.out.println("file == null:::::::::"+(file==null));
		
		
		ResultModel resultModel = new ResultModel();

		//String path1 = request.getSession().getServletContext().getRealPath("/");
		String foldName = request.getParameter("thumb_config");
		String path = "/upload/images/activity/"+foldName+"/";

		//System.out.println("===========" + path);
		
		String originalname = file.getOriginalFilename();
		String extents = originalname.substring(originalname.indexOf("."));
		
		String fileName = new Date().getTime()+extents;
		System.out.println("filename=="+fileName);

		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
			resultModel.setCode("20000");
			resultModel.setMessage("upload ok");
			
			String urlString = "/activity/"+foldName+"/"+fileName;
			resultModel.setData(urlString);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			resultModel.setCode("50000");
			resultModel.setMessage("uploal_error");
			
		}

		return resultModel;

	}
	
	
	@RequestMapping(value = "pictures")
	public String activityPicUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {

		
		/**
		 * 上传照片
		 * @params : 
		 * dir：存放目录
		 * source=ajaxuploader，说明这是ajaxuploader上传
		 * @return :json
		 */
		ResultModel resultModel = new ResultModel();

		//String path1 = request.getSession().getServletContext().getRealPath("/");
		String path = "/upload/images/activity/upload/";

		System.out.println("===========" + path);
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";

		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		resultModel.setCode("20000");
		resultModel.setMessage("upload ok");
		resultModel.setData("success");

		request.setAttribute("fileUrl", "http://www.huodongshu.com/html/h5/data/event/event_logo/7.jpg");
		return "fileuploadresult";

	}

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public String activityUpload() {
		return "fileupload2";
	}
	

}
