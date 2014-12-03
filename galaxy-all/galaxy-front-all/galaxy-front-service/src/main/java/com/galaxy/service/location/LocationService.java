package com.galaxy.service.location;

import java.util.ArrayList;

import com.galaxy.dal.domain.location.Area;
import com.galaxy.dal.domain.location.City;
import com.galaxy.dal.domain.location.Province;

/*author:huangshanqi
 *time  :2014年12月3日 下午9:41:05
 *email :hsqmobile@gmail.com
 */
public interface LocationService {

	//province
	public ArrayList<Province> getAllProvince();
	
	//city
	public ArrayList<City> getCitysByProvinceCode(String provinceCode);
	//area
	public ArrayList<Area> getAreasByCityCode(String cityCode);
}
