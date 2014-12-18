package com.galaxy.dal.activity.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.activity.ActivityComment;

/*author:huangshanqi
 *time  :2014年10月20日 下午9:35:46
 *email :hsqmobile@gmail.com
 */
public interface ActivityCommentMapper extends BaseMapper<ActivityComment> {

	//统计user_id评论过的活动数
		public int getUserComActNum(@Param("userId")Long userId);
		//分页得到某活动的评论
		public ArrayList<ActivityComment> getActComSortByTime(@Param("activityId")Long activityId,@Param("offset")Integer offset,@Param("pageSize")Integer pageSize);
		public ArrayList<ActivityComment> getAllActComSortByTime(@Param("activityId")Long activityId);
		//分页得到用户评论过的活动
		public List<ActivityComment> getUserComedActSortByTime(@Param("userId")Long userId,@Param("offset")int offset,@Param("pageSize")int pageSize);
}
