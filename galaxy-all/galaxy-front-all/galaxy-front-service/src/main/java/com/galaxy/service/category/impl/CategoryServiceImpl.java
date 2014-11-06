package com.galaxy.service.category.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.category.mapper.CategoryMapper;
import com.galaxy.dal.domain.category.Category;
import com.galaxy.service.category.CategoryService;

/*author:huangshanqi
 *time  :2014年10月25日 下午2:37:54
 *email :hsqmobile@gmail.com
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	@Override
	public ArrayList<Category> getCategories(long parent_id) {
		// TODO Auto-generated method stub
		return categoryMapper.getCategories(parent_id);
	}

}
