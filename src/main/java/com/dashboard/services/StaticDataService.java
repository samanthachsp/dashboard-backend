package com.dashboard.services;

import java.util.List;

import com.dashboard.model.portal.UserGroup;


public interface StaticDataService {
	
	public List<UserGroup> getGroups() throws Exception;
	
}
