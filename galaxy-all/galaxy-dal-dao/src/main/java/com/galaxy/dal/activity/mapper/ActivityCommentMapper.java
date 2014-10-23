package com.galaxy.dal.activity.mapper;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.domain.activity.ActivityComment;

/*author:huangshanqi
 *time  :2014年10月20日 下午9:35:46
 *email :hsqmobile@gmail.com
 */
public interface ActivityCommentMapper extends BaseMapper<ActivityComment> {

	//统计user_id评论过的活动数
	public int getUserComActNum(@Param("user_id") Long user_id);
}
