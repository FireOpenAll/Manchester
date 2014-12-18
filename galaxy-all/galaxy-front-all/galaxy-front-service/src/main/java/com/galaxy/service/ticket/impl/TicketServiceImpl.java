package com.galaxy.service.ticket.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galaxy.dal.activity.mapper.ActivityMapper;
import com.galaxy.dal.activity.mapper.ActivityTicketMapper;
import com.galaxy.dal.domain.activity.ActivityTicket;
import com.galaxy.dal.domain.ticket.Ticket;
import com.galaxy.dal.ticket.mapper.TicketMapper;
import com.galaxy.service.ticket.TicketService;

/*author:huangshanqi
 *time  :2014年12月6日 下午3:43:49
 *email :hsqmobile@gmail.com
 */
@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketMapper ticketMapper;
	@Autowired
	private ActivityTicketMapper activityTicketMapper;
	

	/**
	 * return the ticket id
	 * @param ticket
	 * @return
	 */
	@Override
	@Transactional
	public boolean createTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		Ticket temp = ticketMapper.getByActivityIdTicketName(ticket.getActivityId(), ticket.getTicketName());
		if(temp != null){
			return false;
		}
		ticketMapper.insert(ticket);
		
		ActivityTicket activityTicket = new ActivityTicket();
		activityTicket.setCreatedTime(ticket.getCreatedTime());
		activityTicket.setUpdatedTime(ticket.getUpdatedTime());
		activityTicket.setActivityId(ticket.getActivityId());
		activityTicket.setTicketId(ticket.getId());
		
		return activityTicketMapper.insert(activityTicket);
	}

	@Override
	public boolean updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketMapper.update(ticket);
	}

	@Override
	public boolean deleteTicketById(Long id) {
		// TODO Auto-generated method stub
		return ticketMapper.deleteById(id);
	}

	@Override
	public Ticket getTicketById(Long id) {
		// TODO Auto-generated method stub
		return ticketMapper.getById(id);
	}



    ////
	
	@Override
	public boolean createActivityTicket(ActivityTicket activityTicket) {
		// TODO Auto-generated method stub
		ActivityTicket temp = activityTicketMapper.getByActIdTicketId(activityTicket.getActivityId(), activityTicket.getTicketId());
		if(temp != null){
			return false;
		}
		return activityTicketMapper.insert(activityTicket);
	}

	@Override
	@Transactional
	public List<Ticket> getAllAcitivityTicket(Long activityId) {
		// TODO Auto-generated method stub
		List<ActivityTicket> temp = activityTicketMapper.getAllAcitivityTicket(activityId);
		if(temp != null){
			List<Ticket> tickets = new ArrayList<Ticket>();
			for(ActivityTicket activityTicket:temp){
				Ticket ticket = ticketMapper.getById(activityTicket.getTicketId());
				if(ticket != null){
					tickets.add(ticket);
				}
			}
			return tickets;
		}
		return null;
	}

	@Override
	public boolean deleteAcitivityTicketById(Long id) {
		// TODO Auto-generated method stub
		return activityTicketMapper.deleteById(id);
	}

}
