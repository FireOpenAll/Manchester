package com.galaxy.dal.activity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.activity.ActivityCollectUser;

/*author:huangshanqi
 *time  :2014年12月11日 下午7:51:32
 *email :hsqmobile@gmail.com
 */
public interface ActivityCollectMapper extends BaseMapper<ActivityCollectUser> {

	public int getUserCollectActNum(@Param("userId") Long userId);
	public List<ActivityCollectUser> getActCollectSortByTime(@Param("activityId") Long activityId,@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);
	public List<ActivityCollectUser> getUserCollectedActSortByTime(@Param("userId") Long userId,@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);
	public ActivityCollectUser getByUserIdActId(@Param("userId") Long userId,@Param("activityId") Long activityId);
}
