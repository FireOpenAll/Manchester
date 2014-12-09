package com.galaxy.dal.activity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.activity.ActivityTicket;
import com.galaxy.dal.domain.activity.ActivityUser;

/*author:huangshanqi
 *time  :2014年12月6日 下午4:43:54
 *email :hsqmobile@gmail.com
 */
public interface ActivityTicketMapper extends BaseMapper<ActivityTicket> {

	public ActivityTicket getByActIdTicketId(@Param("activityId") Long activityId,@Param("ticketId") Long ticketId);
    public List<ActivityTicket> getAllAcitivityTicket(@Param("activityId") Long activityId);
}
