package com.galaxy.front.web.rest.card;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;





import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.card.Card;
import com.galaxy.dal.domain.card.CardBook;
import com.galaxy.front.web.rest.model.ListModel;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.rest.model.card.CardModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ParamUtils;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.card.CardService;
/*author:huangshanqi
 *time  :2014年10月14日 下午9:18:56
 *email :hsqmobile@gmail.com
 */

@RestController(value = "RestCardController")
@RequestMapping(value = "/api/v1/user/card")
public class CardController {
	
	@Autowired
	private CardService cardService;

	/**
	 * 根据用户id获取他的名片
	 * @return
	 */
	/*
	private Long card_id;
	private Long user_id;
	private String name;// 名字
	private String company;// 公司
	private String title;// 职位
	private String phone;
	private String email;
	private String address;
	private String website;// 个人主页
	private String qq;
	private String weixin;
	private String photo;// 头像URL
	private String qrcode;// 名片二维码地址
	 */
	

	/**
	 * 创建我自己的名片
	 * @param user_id
	 * @return
	 */
	
	@RequestMapping(value = "create",method = RequestMethod.POST)
	public Object createMyCard(HttpServletRequest request,@ModelAttribute Card card){
		
		System.out.println("coming into createMyCard");

		
		ResultModel resultModel = new ResultModel();
		
		
		//用户名和用户id必须传进来
		if (ParamUtils.isNotEmpty(card.getUser_id(),card.getName())) {
			
			if (cardService.getCardByUserId(card.getUser_id()) != null) {
				//该user_id已经创建名片
				resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_ADD_EXISTS);
			}else {
				card.setCreatedTime(new Timestamp(new Date().getTime()));
				if (cardService.createCard(card)) {
					//创建名片成功
					resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
					resultModel.setData("创建名片成功");
				}else{
					//创建失败
					resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_ADD_ERROR);
				}
			}
			
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData("请输入正确的参数");
		}	
		return resultModel;
	}
	
	
	/**
	 * 获取我自己的名片
	 * @param user_id
	 * @return
	 */
	/*
	@RequestMapping(value = "get",method = RequestMethod.GET,params={"user_id"})
	public Object getMyCardByUserId(@RequestParam("user_id") Long user_id){
		ResultModel resultModel = new ResultModel();
		
		if (ParamUtils.isNotEmpty(user_id)) {
			resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
			
			System.out.println("come into getMyCardByUserId!!!!!!!!!!!!!!!!!!!");
			
			Card card = cardService.getCardByUserId(user_id);
			
			resultModel.setData(card);
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData("请输入正确的参数");
		}	
		return resultModel;
	}
	*/
	/**
	 * 获取用户名片，user_id=target_id为查询用户自己的
	 * @param user_id
	 * @param target_id
	 * @return
	 */
	@RequestMapping(value = "get",method = RequestMethod.GET,params={"user_id","target_id"})
	public Object getOtherCardByUserId(@RequestParam("user_id") Long user_id,@RequestParam("target_id") Long target_id){
		ResultModel resultModel = new ResultModel();
		
		if (ParamUtils.isNotEmpty(user_id,target_id)) {
			if (user_id.equals(target_id)) {
				//查询用户自己的名片
				Card card = cardService.getCardByUserId(user_id);
				if (card != null) {
					
					resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
					resultModel.setData(card);
				}else {
					//用户还没创建名片
					resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
					resultModel.setData("参数错误或者用户未创建名片");
				}
			}else {
				//用户查询他人的
				Card card = cardService.getCardByUserId(target_id);
				if (card != null) {
					CardModel cardModel = new CardModel();
					cardModel.setCard(card);
					if (cardService.checkisAdded(user_id, target_id)) {
						cardModel.setAdded(true);
					}else {
						cardModel.setAdded(false);
					}
					resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
					resultModel.setData(cardModel);
				}else {
					//用户还没创建名片
					resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
					resultModel.setData("参数错误或者用户未创建名片");
				}
			}
		}else {
			//参数不全
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
		}
		
		
		/*
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		
		System.out.println("come into getOtherCardByUserId!!!!!!!!!!!!!!!!!!!"+user_id);
		
		CardModel cardModel = new CardModel();
		cardModel.setCard_id(789789789L);
		cardModel.setUser_id(target_id);
		cardModel.setName("chengjiedi");
		cardModel.setCompany("北京邮电大学");
		cardModel.setTitle("Android研发工程师");
		cardModel.setPhone("12345678901");
		cardModel.setEmail("chenjiedi@bupt.edu.cn");
		cardModel.setAddress("北京市海淀区西土城路10号");
		cardModel.setWebsite("www.bbs.byr.cn");
		cardModel.setQq("88888888");
		cardModel.setWeixin("jiedichen");
		cardModel.setPhoto("/user/avatar/10.jpg");
		cardModel.setQrcode("/user/avatar/11.jpg");
		cardModel.setAdded(true);
		
		resultModel.setData(cardModel);
		
		*/
		return resultModel;
	}
	
	/**
	 * 修改我的名片,修改时用户名name字段必须有
	 * @param cardModel
	 * @return
	 */
	@RequestMapping(value = "card",method = RequestMethod.POST, 
			params = {"user_id","name","company","title","phone","email","address","website","qq","weixin","photo"})
	public Object ModifyCardbyUserId(@ModelAttribute Card card){
		ResultModel resultModel = new ResultModel();
		if (ParamUtils.isNotEmpty(card.getUser_id())) {
			if (cardService.modefyCard(card)) {
				card = cardService.getCardByUserId(card.getUser_id());
				resultModel.setData(card);
			}else {
				resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_UPDATE_ERROR);
				resultModel.setData("更新失败");
			}
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData("name字段必须有");
		}	
		
		return resultModel;
	}
	
	/**
	 * 将名片添加到我的名片夹
	 * @param user_id
	 * @param card_id
	 * @return
	 */
	@RequestMapping(value = "add",method = RequestMethod.POST, params = {"user_id","card_id"})
	public Object addCardToMyBook(@RequestParam("user_id") Long user_id,@RequestParam("card_id") Long card_id){
		ResultModel resultModel = new ResultModel();
		if (ParamUtils.isNotEmpty(user_id,card_id)) {
			if (cardService.checkisAddedByUserIdCardId(user_id, card_id)) {
				//已添加
				resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_ADD_EXISTS);
				resultModel.setData(new StatusModel("added already"));
			}else{
				CardBook cardBook = new CardBook();
				cardBook.setUser_id(user_id);
				cardBook.setCard_id(card_id);
				if (cardService.addCardToMyBook(cardBook)) {
					resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
					resultModel.setData(new StatusModel("ok"));
				}else {
					resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_ADD_ERROR);
					resultModel.setData(new StatusModel("failed"));
				}
			}
			
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(new StatusModel("failed"));
		}
		
		/*
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resultModel.setData(new StatusModel("ok"));
		*/
		return resultModel;
	}
    
	/**
	 * 从我的名片夹里删除名片
	 * @param user_id
	 * @param card_id
	 * @return
	 */
	@RequestMapping(value = "delete",method = RequestMethod.DELETE, params = {"user_id","card_id"})
	public Object deleteCardFormMyBook(@RequestParam("user_id") Long user_id,@RequestParam("card_id") Long card_id){
		ResultModel resultModel = new ResultModel();
		if (ParamUtils.isNotEmpty(user_id,card_id)) {
			if (cardService.deleteCardFormMyBook(user_id, card_id)) {
				resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
				resultModel.setData(new StatusModel("ok"));
			}else {
				resultModel = ResultModelUtils.getResultModelByCode(Code.SQL_DELETE_ERROR);
				resultModel.setData(new StatusModel("failed"));
			}
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(new StatusModel("failed"));
		}
		/*
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resultModel.setData(new StatusModel("ok"));
		*/
		return resultModel;
	}
	
	/**
	 * 得到用户名片夹的所有名片
	 * @param user_id
	 * @return
	 */
	@RequestMapping(value = "all",method = RequestMethod.GET, params = {"user_id"})
	public Object getAllCradFromMyBook(@RequestParam("user_id") Long user_id){
		ResultModel resultModel = new ResultModel();
		
		if (ParamUtils.isNotEmpty(user_id)) {
			ListModel<Card> listModel = new ListModel<Card>();
			List<Card> cardModels = cardService.getAllCradsFromMyBook(user_id);
			listModel.setCount(cardModels.size());
			listModel.setList(cardModels);
			resultModel.setData(listModel);
			
		}else {
			resultModel = ResultModelUtils.getResultModelByCode(Code.PARAMS_ERROR);
			resultModel.setData(new StatusModel("failed"));
		}
		
		/*
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		
		ListModel<CardModel> listModel = new ListModel<CardModel>();
		ArrayList<CardModel> cardModels = new ArrayList<CardModel>();
		listModel.setCount(20);
		for (int i = 0; i < 20; i++) {
			CardModel cardModel = new CardModel();

			cardModel.setCard_id(100000000L+i);
			cardModel.setUser_id(200000000L+i*2);
			cardModel.setName("name"+i);
			cardModel.setCompany("第"+i+"分公司");
			cardModel.setTitle("Android研发工程师"+i+"级");
			cardModel.setPhone("1234567890"+(i%10));
			cardModel.setEmail("chenjiedi@bupt.edu.cn"+i);
			cardModel.setAddress("北京市海淀区西土城路 "+i+" 号");
			cardModel.setWebsite("www.bbs.byr.cn"+i);
			cardModel.setQq("88888888"+i);
			cardModel.setWeixin("jiedichen"+i);
			cardModel.setPhoto("/user/avatar/"+(10+i)+".jpg");
			cardModel.setQrcode("/user/avatar/"+(10+i)+".jpg");
			
			cardModels.add(cardModel);
		}
		listModel.setList(cardModels);
		resultModel.setData(listModel);
		
		*/
		return resultModel;
	}
	
	
}
