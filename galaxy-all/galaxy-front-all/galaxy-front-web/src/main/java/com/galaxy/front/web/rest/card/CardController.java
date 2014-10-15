package com.galaxy.front.web.rest.card;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.front.web.rest.model.ListModel;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.rest.model.StatusModel;
import com.galaxy.front.web.rest.model.card.CardModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;
/*author:huangshanqi
 *time  :2014年10月14日 下午9:18:56
 *email :hsqmobile@gmail.com
 */

@RestController(value = "RestCardController")
@RequestMapping(value = "/api/v1/user/card")
public class CardController {

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
	private String qrCodeUrl;// 名片二维码地址
	 */
	@RequestMapping(value = "get",method = RequestMethod.GET,params={"user_id"})
	public Object getCardByUserId(@RequestParam("user_id") Long user_id){
		ResultModel resultModel = new ResultModel();
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		
		CardModel cardModel = new CardModel();
		cardModel.setCard_id(789789789L);
		cardModel.setUser_id(user_id);
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
		cardModel.setQrCodeUrl("/user/avatar/11.jpg");
		
		resultModel.setData(cardModel);
		
		return resultModel;
	}
	
	/**
	 * 修改我的名片
	 * @param cardModel
	 * @return
	 */
	@RequestMapping(value = "card",method = RequestMethod.POST, 
			params = {"card_id","user_id","name","company","title","phone","email","address","website","qq","weixin","photo","qrCodeUrl"})
	public Object ModifyCardbyUserId(@ModelAttribute CardModel cardModel){
		
		System.out.println(cardModel.toString());
		
		ResultModel resultModel = new ResultModel();
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resultModel.setData(cardModel);
		
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
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resultModel.setData(new StatusModel("ok"));
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
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resultModel.setData(new StatusModel("ok"));
		
		return resultModel;
	}
	
	/**
	 * 得到用户的所有名片
	 * @param user_id
	 * @return
	 */
	@RequestMapping(value = "all",method = RequestMethod.GET, params = {"user_id"})
	public Object getAllCradFromMyBook(@RequestParam("user_id") Long user_id){
		ResultModel resultModel = new ResultModel();
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
			cardModel.setQrCodeUrl("/user/avatar/"+(10+i)+".jpg");
			
			cardModels.add(cardModel);
		}
		listModel.setList(cardModels);
		resultModel.setData(listModel);
		
		return resultModel;
	}
	
	
}
