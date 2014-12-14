package com.galaxy.dal.location.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.location.City;

/*author:huangshanqi
 *time  :2014年10月8日 上午9:17:04
 *email :hsqmobile@gmail.com
 */
public interface CityMapper extends BaseMapper<City> {

	public ArrayList<City> getCitysByProvinceCode(@Param("provinceCode") String provinceCode);
}
