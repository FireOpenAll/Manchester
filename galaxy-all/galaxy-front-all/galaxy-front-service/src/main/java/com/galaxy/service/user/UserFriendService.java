package com.galaxy.service.user;

import java.util.List;

import com.galaxy.dal.domain.user.User;
import com.galaxy.dal.domain.user.UserFriend;
import com.galaxy.dal.domain.user.UserFriendApply;

/*author:huangshanqi
 *time  :2014年12月13日 下午2:21:00
 *email :hsqmobile@gmail.com
 */
public interface UserFriendService {
	

	
	public boolean createUserFriend(UserFriend userFriend);
    public boolean deleteUserFriend(Long userFriendId);
    public boolean deleteUserFriendByUseridTargetid(Long userId,Long targetId);
    public boolean hasAddFriend(Long userId,Long targetId);
    public UserFriend getUserFriendByUidTid(Long userId,Long targetId);
	public List<User> getAllUserFriend(Long userId);
	
	
	public UserFriendApply getUserFriendApplyByid(Long applyId);
	public boolean acceptFriendApply(UserFriend userFriend);
	public boolean createUserFriendApply(UserFriendApply userFriendApply);
	public boolean deleteUserFriendApply(Long userFriendApplyId);
	public UserFriendApply getUserFriendApplyByUidTid(Long userId,Long targetId);
	public List<UserFriendApply> getAllUserFriendApply(Long userId);
}
