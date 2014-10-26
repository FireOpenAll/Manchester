package com.galaxy.service.category;

import java.util.ArrayList;
import com.galaxy.dal.domain.category.Category;

/*author:huangshanqi
 *time  :2014年10月25日 下午2:36:41
 *email :hsqmobile@gmail.com
 */
public interface CategoryService {

	public ArrayList<Category> getCategories(int level,Long parent_id);

}
