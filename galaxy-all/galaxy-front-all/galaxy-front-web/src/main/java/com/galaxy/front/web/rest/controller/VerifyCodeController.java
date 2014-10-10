/**
 * 
 */
package com.galaxy.front.web.rest.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ResultModel;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * @author luolishu
 *
 */
@Controller
@RequestMapping(value = "api/v1/code")
public class VerifyCodeController {

	@Autowired
	private Producer captchaProducer;

	@ResponseBody
	@RequestMapping(value = "/mobile_code", method = RequestMethod.GET)
	public Object getCode() {
		ResultModel result = new ResultModel();
		result.setCode("20000");
		result.setMessage("get verifyCode success");
		// AuthResultModel authModel=new AuthResultModel();
		VerifyInfo verifyInfo = new VerifyInfo();
		verifyInfo.setVerify_code("123456");
		verifyInfo.setVerify_image("");
		result.setData(verifyInfo);
		return result;
	}
	
	@RequestMapping(value = "/image_code", method = RequestMethod.GET)
	public void getImage(HttpServletRequest request, HttpServletResponse response) {
		
		// Set to expire far in the past.  
        response.setDateHeader("Expires", 0);  
        // Set standard HTTP/1.1 no-cache headers.  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        // Set standard HTTP/1.0 no-cache header.  
        response.setHeader("Pragma", "no-cache");  

        // return a jpeg  
        response.setContentType("image/jpeg");

		String imageCode = captchaProducer.createText();

		System.out.println("imageCode=================---" + imageCode);

		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, imageCode);
		BufferedImage bufferedImage = captchaProducer.createImage(imageCode);
		String format = "jpg";
		// File file = new File("/upload/images/user/verifyImage/1.jpg");

		// write the data out
		try {
			ServletOutputStream out = response.getOutputStream();
			ImageIO.write(bufferedImage, format, out);
			try {
				out.flush();
			} finally {
				out.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * try { ImageIO.write(bufferedImage, format, file); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
/*
		ResultModel result = new ResultModel();
		result.setCode("20000");
		result.setMessage("get imageCode url success");

		VerifyInfo verifyInfo = new VerifyInfo();
		verifyInfo.setVerify_code("");
		verifyInfo.setVerify_image("/user/verifyImage/1.jpg");
		result.setData(verifyInfo);
*/
	}
	
	
	@RequestMapping(value = "/check_image", method = RequestMethod.GET,params={"captcha"})
	public void checkImageCode(HttpServletRequest request,HttpServletResponse response,@RequestParam("captcha") String captcha) throws IOException {
		if (captcha.equalsIgnoreCase(request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString())){
			response.getOutputStream().print(true);
		}else {
			response.getOutputStream().print(false);
		}
	}
	

	public static class VerifyInfo implements Serializable {
		private String verify_code;
		private String verify_image;

		public VerifyInfo() {
			super();
		}

		public VerifyInfo(String verify_code, String verify_image) {
			super();
			this.verify_code = verify_code;
			this.verify_image = verify_image;
		}

		public String getVerify_code() {
			return verify_code;
		}

		public void setVerify_code(String verify_code) {
			this.verify_code = verify_code;
		}

		public String getVerify_image() {
			return verify_image;
		}

		public void setVerify_image(String verify_image) {
			this.verify_image = verify_image;
		}

	}
}
