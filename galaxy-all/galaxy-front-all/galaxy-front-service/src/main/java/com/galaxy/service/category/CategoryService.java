package com.galaxy.service.category;

import java.util.ArrayList;
import com.galaxy.dal.domain.category.Category;

/*author:huangshanqi
 *time  :2014年12月9日 下午10:53:16
 *email :hsqmobile@gmail.com
 */
public interface CategoryService {

	public boolean createCategory(Category category);
	public boolean updateCategoryInfo(Category category);
	public boolean deleteCategoryById(Long categoryId);
	public ArrayList<Category> getAllCategory();
	public ArrayList<Category> getChildrenCategory(Long parentId);
}
