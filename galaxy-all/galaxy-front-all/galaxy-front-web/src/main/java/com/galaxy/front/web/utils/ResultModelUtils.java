package com.galaxy.front.web.utils;

import org.junit.Test;

import com.galaxy.front.web.rest.model.ResultModel;
/*author:huangshanqi
 *time  :2014年10月7日 下午5:02:06
 *email :hsqmobile@gmail.com
 */
public class ResultModelUtils {
	/*
	 * 客户端返回model工具类
	 */
	
	
	/**
	 * 将一个Code封装进一个ResultModel里
	 * @param code
	 * @return
	 */
	public static ResultModel getResultModelByCode(Code code){
		ResultModel resultModel = new ResultModel();
		resultModel.setCode(code.getCode());
		resultModel.setMessage(code.getMessage());
		return resultModel;
	}
	

}
