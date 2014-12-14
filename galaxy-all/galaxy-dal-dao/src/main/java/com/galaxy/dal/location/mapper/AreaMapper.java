package com.galaxy.dal.location.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.location.Area;

/*author:huangshanqi
 *time  :2014年10月8日 上午9:17:59
 *email :hsqmobile@gmail.com
 */
public interface AreaMapper extends BaseMapper<Area> {
	public ArrayList<Area> getAreasByCityCode(@Param("cityCode") String cityCode);

}
