package com.galaxy.dal.location.mapper;

import java.awt.List;
import java.util.ArrayList;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.location.Province;

/*author:huangshanqi
 *time  :2014年10月8日 上午9:10:56
 *email :hsqmobile@gmail.com
 */
public interface ProvinceMapper extends BaseMapper<Province> {
	public ArrayList<Province> getAllProvince();
	

}
