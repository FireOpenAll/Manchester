package com.galaxy.service.ticket;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.domain.activity.ActivityTicket;
import com.galaxy.dal.domain.ticket.Ticket;

/*author:huangshanqi
 *time  :2014年12月6日 下午3:42:24
 *email :hsqmobile@gmail.com
 */
public interface TicketService {

	
	public boolean createTicket(Ticket ticket);

	public boolean updateTicket(Ticket ticket);

	public boolean deleteTicketById(Long id);

	public Ticket getTicketById(Long id);
	
	//
	public boolean createActivityTicket(ActivityTicket activityTicket);
	public List<Ticket> getAllAcitivityTicket(Long actiityId);
	public boolean deleteAcitivityTicketById(Long id);

}
