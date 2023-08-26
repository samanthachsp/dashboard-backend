package com.dashboard.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.dao.portal.UserGroupRepository;
import com.dashboard.model.portal.UserGroup;

@Service
public class StaticData implements StaticDataService {
	
	private List<UserGroup> groups = new ArrayList<UserGroup>();
	
	@Autowired
	UserGroupRepository groupRepository;
	

	public List<UserGroup> getGroups(){
		if(groups.size() == 0) {
			groups = groupRepository.findAll();
		}
		return groups;
	}

}
