package com.galaxy.service.location.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.domain.location.District;
import com.galaxy.dal.location.mapper.DistrictMapper;
import com.galaxy.service.location.DistrictService;

/*author:huangshanqi
 *time  :2014年10月8日 上午12:28:27
 *email :hsqmobile@gmail.com
 */

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	DistrictMapper districtMapper;

	@Override
	public ArrayList<District> getDistrictsByCityCode(String city_code) {
		// TODO Auto-generated method stub
		return districtMapper.getDistrictsByCityCode(city_code);
	}
}
