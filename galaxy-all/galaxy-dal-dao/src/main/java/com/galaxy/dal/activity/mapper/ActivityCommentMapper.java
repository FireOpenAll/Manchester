package com.galaxy.dal.activity.mapper;

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
	public int getUserComActNum(@Param("user_id") Long user_id);
	//统计某个活动总的评论数
	public int getActComNum(@Param("activity_id") Long activityId);
	//分页得到用户评论过的活动
	public List<ActivityComment> getUserComedActByUntilId(@Param("user_id") long userId,@Param("until_id") long untilId,@Param("pageSize") long pageSize);
	//分页得到某活动的评论
	public List<ActivityComment> getActComByUntilId(@Param("activityId") Long activityId, @Param("untilId") Long untilId,@Param("pageSize") int pageSize );
}
