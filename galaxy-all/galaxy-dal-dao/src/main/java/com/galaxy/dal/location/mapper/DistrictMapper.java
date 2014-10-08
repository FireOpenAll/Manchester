package com.galaxy.dal.location.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.location.District;

/*author:huangshanqi
 *time  :2014年10月8日 上午9:17:59
 *email :hsqmobile@gmail.com
 */
public interface DistrictMapper extends BaseMapper<District> {
	public ArrayList<District> getDistrictsByCityCode(@Param("city_code") String city_code);

}
