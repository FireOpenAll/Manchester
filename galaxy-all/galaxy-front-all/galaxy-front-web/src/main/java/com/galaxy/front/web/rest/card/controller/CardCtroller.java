package com.galaxy.front.web.rest.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.service.card.CardService;

/*author:huangshanqi
 *time  :2014年12月13日 下午10:46:14
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping("api/v1/user/card")
public class CardCtroller {

	@Autowired
	private CardService  cardService;
	
	@RequestMapping(value="getAllCard",method=RequestMethod.GET)
	public Object getAllCard(){
		ResultModel resultModel = new ResultModel();
		
		
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
