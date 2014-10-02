package com.galaxy.front.web.rest.upload.controller;

import java.io.File;
import java.io.IOException;
import java.security.interfaces.RSAKey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.galaxy.front.web.rest.model.ResultModel;

@Controller
@RequestMapping(value = "/picture")
public class ActivityPicUploadController {

	@RequestMapping(value = "activities")
	public String activityPicUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {

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

		request.setAttribute("fileUrl", "http://182.92.169.209/activity/upload/"+ fileName);
		return "fileuploadresult";

	}

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public String activityUpload() {
		return "fileupload2";
	}
}
