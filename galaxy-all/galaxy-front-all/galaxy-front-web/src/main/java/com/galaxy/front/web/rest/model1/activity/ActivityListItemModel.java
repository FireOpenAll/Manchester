package com.galaxy.front.web.rest.model1.activity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*author:huangshanqi
 *time  :2014年12月6日 下午1:13:26
 *email :hsqmobile@gmail.com
 */
public class ActivityListItemModel implements Serializable {

	private Long activityId;
	private String title;
	private Date startTime;
	private Date endTime;
	private String address;
	private List<String> tags;
	private String cover;
	private Integer joinedNum;
	private Integer commentNum;
	private Double price;
}
