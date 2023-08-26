package com.dashboard.services.common;

import java.util.List;

import com.dashboard.model.portal.User ;


public interface UserService {
	
	/**
	 * @return all the registerOrders
	 */
	public List<User> getUsers(String name) throws Exception;
	

	/**
	 * @return similar registerOrders
	 */
	public User findUserById(String id) throws Exception;


}
