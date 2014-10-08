package com.galaxy.service.location;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.domain.location.City;

/*author:huangshanqi
 *time  :2014年10月8日 上午12:27:09
 *email :hsqmobile@gmail.com
 */
public interface CityService {
	public ArrayList<City> getCitysByProvinceCode(String province_code);

}
