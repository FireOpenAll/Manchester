package com.galaxy.service.location.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.dal.domain.location.Province;
import com.galaxy.dal.location.mapper.ProvinceMapper;
import com.galaxy.service.location.ProvinceService;

/*author:huangshanqi
 *time  :2014年10月8日 上午12:26:01
 *email :hsqmobile@gmail.com
 */
@Service
public class ProvinceServiceImpl implements ProvinceService{

	@Autowired
	ProvinceMapper provinceMapper;
	
	@Override
	public ArrayList<Province> getAllProvince() {
		// TODO Auto-generated method stub
		return provinceMapper.getAllProvince();
	}
	

}
