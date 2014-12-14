package com.galaxy.dal.category.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.category.Category;

/*author:huangshanqi
 *time  :2014年12月9日 下午10:44:51
 *email :hsqmobile@gmail.com
 */
public interface CategoryMapper extends BaseMapper<Category> {

	public ArrayList<Category> getAllCategory();
	public ArrayList<Category> getChildrenCategory(@Param("parentId") Long parentId);
}
