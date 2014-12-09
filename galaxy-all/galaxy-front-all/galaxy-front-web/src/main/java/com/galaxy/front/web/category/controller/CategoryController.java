package com.galaxy.front.web.category.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.galaxy.dal.domain.category.Category;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.category.CategoryService;

/*author:huangshanqi
 *time  :2014年12月9日 下午10:50:24
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping("category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@ResponseBody
	@RequestMapping(value="all",method = RequestMethod.GET)
	public Object getAllCategory(){
		ResultModel resultModel = new ResultModel();
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		/*
		String str = "讲座会议;创业分享;生活聚会;交友约会;比赛竞技;观影演出;展览展会;网络课程;校园;其他";
		int count = 1;
        for(String name:str.split(";")){
        	Category category = new Category();
        	category.setCreatedTime(new Date());
        	category.setUpdatedTime(category.getCreatedTime());
        	category.setNameCh(name);
        	category.setParentId(0L);
        	category.setCoverUrl("/category/covers/" + count++ +".jpg");
        	categoryService.createCategory(category);
        }
		*/
		ArrayList<Category> list = categoryService.getAllCategory();
		
		resultModel.setData(list);
		return resultModel;
	}
	
	@ResponseBody
	@RequestMapping(value="get",method = RequestMethod.GET,params = {"parentId"})
	public Object getChildrenCategory(@RequestParam("parentId") Long parentId){
		ResultModel resultModel = new ResultModel();
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		ArrayList<Category> list = categoryService.getChildrenCategory(parentId);
		
		resultModel.setData(list);
		return resultModel;
	}
	
	
}
