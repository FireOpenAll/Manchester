package com.galaxy.front.web.rest.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.card.CardService;
import com.galaxy.service.user.LoginUserModel;
import com.galaxy.service.user.UserUtils;

/*author:huangshanqi
 *time  :2014年12月13日 下午10:46:14
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping("api/v1/user/card")
public class CardController {

	@Autowired
	private CardService  cardService;
	
	@RequestMapping(value="getAllCard",method=RequestMethod.GET)
	public Object getAllCard(){
		ResultModel resultModel = new ResultModel();
		
		LoginUserModel loginUser = UserUtils.getLoginUser();
		
		
		return resultModel;
	}
	
	@RequestMapping(value="getCardDetail",method=RequestMethod.GET,params={"targetId"})
	public Object getCardDetail(@RequestParam("targetId") Long targetId){
		ResultModel resultModel = new ResultModel();
		if(ParamUtils.isNotEmpty(targetId)){
			LoginUserModel loginUser = UserUtils.getLoginUser();
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			
			
			
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		
		
		
		return resultModel;
	}
	
//	@RequestMapping(value="delete",method=RequestMethod.GET,params={"cardId"})
//	public Object deleteByCardId(){
//		ResultModel resultModel = new ResultModel();
//		
//		
//		return resultModel;
//	}
//	
//	@RequestMapping(value="addCard",method=RequestMethod.GET,params={"cardId"})
//	public Object deleteByCardId(){
//		ResultModel resultModel = new ResultModel();
//		
//		
//		return resultModel;
//	}
	
	
}
