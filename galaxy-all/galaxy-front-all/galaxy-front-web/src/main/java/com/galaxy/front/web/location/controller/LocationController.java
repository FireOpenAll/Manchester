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
	
	@RequestMapping(value = "city", method = RequestMethod.GET, params = { "provinceCode" })
	public Object getCitys(@RequestParam("provinceCode") String provinceCode) {
		ResultModel resulltModel = new ResultModel();
		ArrayList<City> list = locationService.getCitysByProvinceCode(provinceCode);

		resulltModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resulltModel.setData(list);

		return resulltModel;
	}
	
	@RequestMapping(value = "area", method = RequestMethod.GET, params = {"cityCode"})
	public Object getProvince(@RequestParam("cityCode") String cityCode) {
		ResultModel resulltModel = new ResultModel();
		ArrayList<Area> list = locationService.getAreasByCityCode(cityCode);

		resulltModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resulltModel.setData(list);

		return resulltModel;

	}

}
