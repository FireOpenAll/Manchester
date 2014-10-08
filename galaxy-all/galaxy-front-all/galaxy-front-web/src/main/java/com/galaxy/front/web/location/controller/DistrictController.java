package com.galaxy.front.web.location.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.galaxy.dal.domain.location.District;
import com.galaxy.front.web.Utils.Code;
import com.galaxy.front.web.Utils.ResultModelUtils;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.service.location.DistrictService;

/*author:huangshanqi
 *time  :2014年10月7日 下午11:33:22
 *email :hsqmobile@gmail.com
 */

@RestController
@RequestMapping(value = "api/v1/location")
public class DistrictController {
	/*
	 * 区相关控制器
	 */

	@Autowired
	DistrictService districtService;

	@RequestMapping(value = "district", method = RequestMethod.GET, params = {"city_code"})
	public Object getProvince(@RequestParam("city_code") String city_code) {
		ResultModel resulltModel = new ResultModel();
		ArrayList<District> list = districtService.getDistrictsByCityCode(city_code);

		resulltModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resulltModel.setData(list);

		return resulltModel;

	}
}
