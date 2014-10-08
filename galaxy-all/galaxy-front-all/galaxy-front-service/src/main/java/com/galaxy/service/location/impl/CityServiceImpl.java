package com.galaxy.service.location.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.domain.location.City;
import com.galaxy.dal.location.mapper.CityMapper;
import com.galaxy.service.location.CityService;

/*author:huangshanqi
 *time  :2014年10月8日 上午12:27:40
 *email :hsqmobile@gmail.com
 */

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityMapper cityMapper;
	
	@Override
	public ArrayList<City> getCitysByProvinceCode(String province_code) {
		// TODO Auto-generated method stub
		return cityMapper.getCitysByProvinceCode(province_code);
	}

}
