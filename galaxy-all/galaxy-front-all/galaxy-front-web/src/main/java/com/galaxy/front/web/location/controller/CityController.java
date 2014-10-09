package com.galaxy.front.web.location.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.galaxy.dal.domain.location.City;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.service.location.CityService;

/*author:huangshanqi
 *time  :2014年10月7日 下午11:33:07
 *email :hsqmobile@gmail.com
 */

@RestController
@RequestMapping(value = "api/v1/location")
public class CityController {
	/*
	 * 城市相关控制器
	 */
	@Autowired
	CityService cityService;

	@RequestMapping(value = "city", method = RequestMethod.GET, params = { "province_code" })
	public Object getCitys(@RequestParam("province_code") String province_code) {
		ResultModel resulltModel = new ResultModel();
		ArrayList<City> list = cityService.getCitysByProvinceCode(province_code);

		resulltModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resulltModel.setData(list);

		return resulltModel;
	}

}
