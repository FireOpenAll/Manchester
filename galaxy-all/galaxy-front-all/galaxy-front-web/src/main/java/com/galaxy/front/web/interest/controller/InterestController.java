package com.galaxy.front.web.interest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.profile.InterestGroup;
import com.galaxy.front.web.rest.model.profile.InterestModel;

/*author:huangshanqi
 *time  :2014年9月20日 下午3:59:54
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping(value = "api/v1/interest")
public class InterestController {
	
	@RequestMapping(value = "/category",method = RequestMethod.GET)
	public Object getTopInterests(){
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("20000");
		resultModel.setMessage("get interest category list success");
		
		List<InterestModel> interestModels = new ArrayList<InterestModel>();
		for (int i = 0; i < 12; i++) {
			interestModels.add(new InterestModel(10000000+i, "推荐兴趣"+ i));
		}
		InterestGroup interestGroup = new InterestGroup(12, interestModels);
		
		resultModel.setData(interestGroup);
		return resultModel;
		
	}

}
