package com.galaxy.dal.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.galaxy.dal.base.mapper.BaseMapper;
import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.domain.user.UserFriend;

/*author:huangshanqi
 *time  :2014年10月22日 上午12:32:10
 *email :hsqmobile@gmail.com
 */
public interface UserFriendMapper extends BaseMapper<UserFriend> {
	
    //insert
	//deleteById
	//"getById"
	
	//查询两用户的关系
	public UserFriend getUsersFriend(@Param("user_id") Long user_id,@Param("target_id") Long target_id);

	
	////关注
	//得到我关注的全部用户
	public List<UserFriend> getFollowings(@Param("user_id") Long user_id);
	//分页得到我关注的用户
	public List<UserFriend> getFollowingsByOffset(PaginationParam paginationParam);
	//得到我关注的用户数
	public int getFollowingsNum(@Param("user_id") Long user_id);
	
	////被关注
	//得到我的全部粉丝
	public List<UserFriend> getFolloweds(@Param("user_id") Long user_id);
	//分页得到我的粉丝
	public List<UserFriend> getFollowedsByOffset(PaginationParam paginationParam);
	//得到我的全部粉丝数
	public int getFollowedsNum(@Param("user_id") Long user_id);

	
	////互粉
	//得到全部我的互粉用户
	public List<UserFriend> getMutualUsers(@Param("user_id") Long user_id);
    //分页得到我的互粉用户
	public List<UserFriend> getMutualUsersByOffset(PaginationParam paginationParam);
    //得到全部我的互粉数
	public int getMutualUsersNum(@Param("user_id") Long user_id);

	
}
