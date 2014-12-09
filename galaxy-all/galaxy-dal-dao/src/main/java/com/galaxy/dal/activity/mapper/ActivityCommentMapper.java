package com.galaxy.dal.activity.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.activity.ActivityComment;

/*author:huangshanqi
 *time  :2014年10月20日 下午9:35:46
 *email :hsqmobile@gmail.com
 */
public interface ActivityCommentMapper extends BaseMapper<ActivityComment> {

	//统计user_id评论过的活动数
		public int getUserComActNum(Long userId);
		//分页得到某活动的评论
		public List<ActivityComment> getActComSortByTime(Long activityId,Date commentTime,Integer pageSize);
		//分页得到用户评论过的活动
		public List<ActivityComment> getUserComedActSortByTime(Long activityId,Long userId,Date commentTime,Long pageSize);
}
