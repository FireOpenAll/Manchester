/**
 * 
 */
package com.galaxy.dal.domain.activity;

import com.galaxy.dal.domain.BaseDomain;

/**
 * @author luolishu
 * 
 */
public class Lecturer extends BaseDomain {
	Long activityId;
	Long conferenceId;
	Long companyId;
	String name;// 讲师姓名
	String position;// 讲师职位描述 
	String desc;// 讲师描述

}
