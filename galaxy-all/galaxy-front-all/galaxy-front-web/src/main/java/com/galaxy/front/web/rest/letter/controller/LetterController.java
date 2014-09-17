package com.galaxy.front.web.rest.letter.controller;

import java.util.ArrayList;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.letter.LetterFeedModel;
import com.galaxy.front.web.rest.model.letter.LetterFeedModel.UserModel;
import com.galaxy.front.web.rest.model.letter.LetterModel;
import com.galaxy.service.letter.LetterService;
@RestController
@RequestMapping(value = "api/v1/letter")
public class LetterController {
	/*
	 * 私信控制器
	 */
	@Autowired
	 LetterService letterService;
	
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET})
	public Object post(){
		ResultModel result=new ResultModel();
		LetterModel model=new LetterModel();
		result.setData(model);
		return result;
		
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Object list() {
		
//		String userid = request.getParameter("user_id");
//		String count = request.getParameter("count");
//		String untilid = request.getParameter("until_id");
		ResultModel resultModel = new ResultModel();
		
		ArrayList<LetterFeedModel> list = new ArrayList<LetterFeedModel>();
		for (int i = 1; i < 6; i++) {
			LetterFeedModel letterFeedModel = new LetterFeedModel();
			letterFeedModel.setUnread(i);
			letterFeedModel.setCount(i*10);
			letterFeedModel.setTarget(new UserModel((long)i*10000000,"/avatar/letter/userid/"+i*10+".jpg","name"+i,(i%2 == 0)?"male":"female"));
			letterFeedModel.setLastLetter(new LetterModel((long)i*10000000,"letter content "+i,new Date(),(long)i*10000000,(long)i*10000000));
			list.add(letterFeedModel);
		}
		resultModel.setCode("20000");
		resultModel.setMessage("get message content");
		//resultModel.setMessage("get letter parameters[user_id="+userid+",count="+count+",until_id="+untilid+"]");
		resultModel.setData(list);
		return  resultModel;
	}

}
