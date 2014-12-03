package com.galaxy.front.web.location.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.location.Area;
import com.galaxy.dal.domain.location.City;
import com.galaxy.dal.domain.location.Province;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.location.LocationService;

/*author:huangshanqi
 *time  :2014年12月3日 下午9:51:42
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping("location")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "province", method = RequestMethod.GET)
	public Object getProvinces() {
		ResultModel resulltModel = new ResultModel();
		ArrayList<Province> list = locationService.getAllProvince();
		resulltModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resulltModel.setData(list);

		return resulltModel;

	}
	
	@RequestMapping(value = "city", method = RequestMethod.GET, params = { "province_code" })
	public Object getCitys(@RequestParam("province_code") String province_code) {
		ResultModel resulltModel = new ResultModel();
		ArrayList<City> list = locationService.getCitysByProvinceCode(province_code);

		resulltModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resulltModel.setData(list);

		return resulltModel;
	}
	
	@RequestMapping(value = "district", method = RequestMethod.GET, params = {"city_code"})
	public Object getProvince(@RequestParam("city_code") String city_code) {
		ResultModel resulltModel = new ResultModel();
		ArrayList<Area> list = locationService.getAreasByCityCode(city_code);

		resulltModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resulltModel.setData(list);

		return resulltModel;

	}

}
