package com.galaxy.service.location;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.domain.location.District;

/*author:huangshanqi
 *time  :2014年10月8日 上午12:28:07
 *email :hsqmobile@gmail.com
 */
public interface DistrictService {
	public ArrayList<District> getDistrictsByCityCode(String city_code);

}
