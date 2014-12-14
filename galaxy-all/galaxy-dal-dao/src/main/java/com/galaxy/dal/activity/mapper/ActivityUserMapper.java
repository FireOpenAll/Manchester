package com.galaxy.dal.activity.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.activity.ActivityUser;

/*author:huangshanqi
 *time  :2014年12月6日 下午4:43:54
 *email :hsqmobile@gmail.com
 */
public interface ActivityUserMapper extends BaseMapper<ActivityUser> {

	public List<ActivityUser> getJoinedUsersSortInTime(@Param("activityId")Long activityId,@Param("offset")int offset, @Param("pageSize")int pageSize);
	//计算user_id参加的活动数
	public int getUserJoinedActNumber(@Param("userId")Long userId);
	
	public List<ActivityUser> getUserJoinedActs(@Param("userId")Long userId,@Param("offset")int offset, @Param("pageSize")int pageSize);
	
	public ActivityUser getByUserIdActIdTicketId(@Param("userId") Long userId,@Param("activityId") Long activityId,@Param("ticketId") Long ticketId);
	public ActivityUser getByUserIdActId(@Param("userId") Long userId,@Param("activityId") Long activityId);

}
