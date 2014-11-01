package com.galaxy.service.user;

import java.util.List;



import com.galaxy.dal.base.mapper.PaginationParam;
import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.domain.user.UserFriend;

/*author:huangshanqi
 *time  :2014年10月22日 上午11:08:00
 *email :hsqmobile@gmail.com
 */
public interface UserFriendService {
	
    //insert
	public boolean insert(UserFriend userFriend);
	//deleteById
	public boolean deleteById(Long id);
	//update
	public boolean update(UserFriend userFriend);
	//getById
	public UserFriend getById(Long id);
	
	//查询两用户的关系
	public UserFriend getUsersFriend(Long user_id,Long target_id);

	
	////关注
	//得到我关注的全部用户
	public List<UserFriend> getFollowings(Long user_id);
	//分页得到我关注的用户
	public List<UserFriend> getFollowingsByOffset(Long user_id,int pageNum,int pageSize);
	//分页得到我关注的用户
	public List<UserFriend> getFollowingsByUntilId(Long userId,long untilId,int pageSize);
	//得到我关注的用户数
	public int getFollowingsNum(Long user_id);
	
	////被关注
	//得到我的全部粉丝
	public List<UserFriend> getFolloweds(Long user_id);
	//分页得到我的粉丝
	public List<UserFriend> getFollowedsByOffset(Long user_id,int pageNum,int pageSize);
	//分页得到我的粉丝
	public List<UserFriend> getFollowedsByUntilId(Long userId,long untilId,int pageSize);
	//得到我的全部粉丝数
	public int getFollowedsNum(Long user_id);


	////互粉
	//得到全部我的互粉用户
	public List<UserFriend> getMutualUsers(Long user_id);
    //分页得到我的互粉用户
	public List<UserFriend> getMutualUsersByOffset(Long user_id,int pageNum,int pageSize);
	//分页得到我的互粉用户
	public List<UserFriend> getMutualUsersByUntilId(Long userId,long untilId,int pageSize);
    //得到全部我的互粉数
	public int getMutualUsersNum(Long user_id);

}
