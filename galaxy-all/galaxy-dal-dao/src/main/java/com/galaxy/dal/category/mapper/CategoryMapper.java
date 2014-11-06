package com.galaxy.dal.category.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.category.Category;

/*author:huangshanqi
 *time  :2014年10月25日 下午2:11:04
 *email :hsqmobile@gmail.com
 */
public interface CategoryMapper extends BaseMapper<Category> {
	
	public ArrayList<Category> getCategories(@Param("parent_id") Long parent_id);

}
