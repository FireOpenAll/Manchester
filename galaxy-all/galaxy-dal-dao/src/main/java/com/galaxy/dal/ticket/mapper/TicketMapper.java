package com.galaxy.dal.ticket.mapper;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.ticket.Ticket;

/*author:huangshanqi
 *time  :2014年12月6日 下午3:49:36
 *email :hsqmobile@gmail.com
 */
public interface TicketMapper extends BaseMapper<Ticket> {
	public Ticket getByActivityIdTicketName(@Param("activityId") Long activityId,@Param("ticketName") String ticketName);

}
