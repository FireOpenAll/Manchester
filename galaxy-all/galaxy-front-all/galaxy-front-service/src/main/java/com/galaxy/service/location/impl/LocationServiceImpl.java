package com.galaxy.service.location.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.domain.location.Area;
import com.galaxy.dal.domain.location.City;
import com.galaxy.dal.domain.location.Province;
import com.galaxy.dal.location.mapper.AreaMapper;
import com.galaxy.dal.location.mapper.CityMapper;
import com.galaxy.dal.location.mapper.ProvinceMapper;
import com.galaxy.service.location.LocationService;

/*author:huangshanqi
 *time  :2014年12月3日 下午9:41:51
 *email :hsqmobile@gmail.com
 */
@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private ProvinceMapper provinceMapper;
	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private AreaMapper areaMapper;
	

	@Override
	public ArrayList<Province> getAllProvince() {
		// TODO Auto-generated method stub
		return provinceMapper.getAllProvince();
	}

	@Override
	public ArrayList<City> getCitysByProvinceCode(String provinceCode) {
		// TODO Auto-generated method stub
		return cityMapper.getCitysByProvinceCode(provinceCode);
	}

	@Override
	public ArrayList<Area> getAreasByCityCode(String cityCode) {
		// TODO Auto-generated method stub
		return areaMapper.getAreasByCityCode(cityCode);
	}


	

}
