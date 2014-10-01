package com.galaxy.service.user;

import com.galaxy.dal.domain.user.User;

public interface UserService {

	User getUser(Long userId);

	boolean createUser(User user);

}
