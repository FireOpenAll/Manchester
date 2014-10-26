package com.galaxy.front.web.category.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.category.Category;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;
/*author:huangshanqi
 *time  :2014年10月25日 下午2:41:05
 *email :hsqmobile@gmail.com
 */
import com.galaxy.service.category.CategoryService;

@RestController
@RequestMapping(value = "/activity/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "get",method = RequestMethod.GET,params = {"level","parent_id"})
	public Object getCategories(@RequestParam("level") int level,@RequestParam("parent_id") Long parent_id){
		ResultModel resultModel = new ResultModel();
		
		resultModel = ResultModelUtils.getResultModelByCode(Code.OK);
		
		ArrayList<Category> lists = categoryService.getCategories(level, parent_id);
		
		resultModel.setData(lists);
		
		return resultModel;
	}
}
