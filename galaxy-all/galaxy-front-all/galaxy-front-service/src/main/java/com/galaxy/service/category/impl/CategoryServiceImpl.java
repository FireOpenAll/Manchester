package com.galaxy.service.category.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.category.mapper.CategoryMapper;
import com.galaxy.dal.domain.category.Category;
import com.galaxy.service.category.CategoryService;

/*author:huangshanqi
 *time  :2014年12月9日 下午10:57:27
 *email :hsqmobile@gmail.com
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public boolean createCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.insert(category);
	}

	@Override
	public boolean updateCategoryInfo(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.update(category);
	}

	@Override
	public boolean deleteCategoryById(Long categoryId) {
		// TODO Auto-generated method stub
		return categoryMapper.deleteById(categoryId);
	}

	@Override
	public ArrayList<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryMapper.getAllCategory();
	}

	@Override
	public ArrayList<Category> getChildrenCategory(Long parentId) {
		// TODO Auto-generated method stub
		return categoryMapper.getChildrenCategory(parentId);
	}

}
