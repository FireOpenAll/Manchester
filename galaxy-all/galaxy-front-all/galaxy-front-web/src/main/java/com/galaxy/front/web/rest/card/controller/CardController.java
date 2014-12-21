package com.galaxy.front.web.rest.card.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.card.Card;
import com.galaxy.dal.domain.card.UserCard;
import com.galaxy.dal.domain.card.UserCardApply;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.rest.model.card.CardBookItemModel;
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
	private CardService cardService;

	@RequestMapping(value = "apply", method = RequestMethod.POST, params = { "targetId", "message" })
	public Object applyCard(@RequestParam("targetId") Long targetId, @RequestParam("message") String message) {
		ResultModel resultModel = new ResultModel();

		LoginUserModel loginUser = UserUtils.getLoginUser();

		UserCardApply apply = new UserCardApply();
		apply.setCreatedTime(new Date());
		apply.setUpdatedTime(apply.getCreatedTime());
		apply.setMessage(message);
		apply.setUserId(loginUser.getUserId());
		apply.setTargetId(targetId);

		if (cardService.createUserCardApply(apply)) {
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(new StatusModel("ok"));
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(new StatusModel("card apply fail"));
		}

		return resultModel;
	}

	@RequestMapping(value = "deleteCard", method = RequestMethod.POST, params = { "targetId" })
	public Object deleteCardFromBook(@RequestParam("targetId") Long targetId) {
		ResultModel resultModel = new ResultModel();

		LoginUserModel loginUser = UserUtils.getLoginUser();

		if (cardService.deleteCardFromBook(loginUser.getUserId(), targetId)) {
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(new StatusModel("delete ok"));
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(new StatusModel("delete card fail"));
		}

		return resultModel;
	}

	@RequestMapping(value = "accept", method = RequestMethod.POST, params = { "targetId" })
	public Object acceptCardApply(@RequestParam("targetId") Long targetId) {
		ResultModel resultModel = new ResultModel();

		LoginUserModel loginUser = UserUtils.getLoginUser();

		// 校验信息
		UserCard userCard = new UserCard();
		userCard.setCreatedTime(new Date());
		userCard.setUpdatedTime(userCard.getCreatedTime());
		userCard.setUserId(loginUser.getUserId());
		userCard.setTargetUserId(targetId);
		
		if (cardService.acceptUserCardApply(userCard)) {
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(new StatusModel("accept ok"));
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(new StatusModel("accept card fail"));
		}

		return resultModel;
	}

	@RequestMapping(value = "allCardApply", method = RequestMethod.GET)
	public Object getAllCardApply() {
		ResultModel resultModel = new ResultModel();

		LoginUserModel loginUser = UserUtils.getLoginUser();

		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resultModel.setData(cardService.getAllUserCardApply(loginUser.getUserId()));

		return resultModel;
	}

	@RequestMapping(value = "getAllCard", method = RequestMethod.GET)
	public Object getAllCard() {
		ResultModel resultModel = new ResultModel();

		LoginUserModel loginUser = UserUtils.getLoginUser();
		ArrayList<Card> list = cardService.getAllFriendCard(loginUser.getUserId());
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
	    resultModel.setData(list);
		return resultModel;
	}

	@RequestMapping(value = "getCardDetail")
	public Object getCardDetail(HttpServletRequest request) {
		ResultModel resultModel = new ResultModel();
		if (request.getParameter("targetId")==null) {
			//获取自己的
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
            resultModel.setData(cardService.getCardByUserId(UserUtils.getLoginUser().getUserId()));
		} else {
			//获取他人的
			Long targetId = Long.valueOf(request.getParameter("targetId"));
			Card card = cardService.getCardByUserId(targetId);
			System.out.println(card);
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			resultModel.setData(card);
		}
		return resultModel;
	}

	@RequestMapping(value="modify",method=RequestMethod.POST)
	public Object modifyCard(Card card){
		ResultModel resultModel = new ResultModel();
		if(ParamUtils.isNotEmpty(card.getId())){
			Card temp = cardService.updateCard(card);
			if(null != temp){
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
				resultModel.setData(temp);
			}else{
				resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
				resultModel.setData(new StatusModel("修改名片失败"));
			}
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		return resultModel;
	}
	
	
	// @RequestMapping(value="delete",method=RequestMethod.GET,params={"cardId"})
	// public Object deleteByCardId(){
	// ResultModel resultModel = new ResultModel();
	//
	//
	// return resultModel;
	// }
	//
	// @RequestMapping(value="addCard",method=RequestMethod.GET,params={"cardId"})
	// public Object deleteByCardId(){
	// ResultModel resultModel = new ResultModel();
	//
	//
	// return resultModel;
	// }

}
