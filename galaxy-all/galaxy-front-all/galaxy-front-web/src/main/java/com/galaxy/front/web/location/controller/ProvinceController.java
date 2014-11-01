package com.galaxy.front.web.location.controller;

import java.security.interfaces.RSAKey;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.dal.domain.location.Province;
import com.galaxy.front.web.rest.model.ResultModel;
import com.galaxy.front.web.utils.Code;
import com.galaxy.front.web.utils.ResultModelUtils;
import com.galaxy.service.location.ProvinceService;

/*author:huangshanqi
 *time  :2014年10月7日 下午11:32:50
 *email :hsqmobile@gmail.com
 */

@RestController
@RequestMapping(value = "location")
public class ProvinceController {
	/*
	 * 省份相关控制器
	 */
	@Autowired
	ProvinceService provinceService;

	@RequestMapping(value = "province", method = RequestMethod.GET)
	public Object getProvinces() {
		ResultModel resulltModel = new ResultModel();
		ArrayList<Province> list = provinceService.getAllProvince();

		resulltModel = ResultModelUtils.getResultModelByCode(Code.OK);
		resulltModel.setData(list);

		return resulltModel;

	}

}
