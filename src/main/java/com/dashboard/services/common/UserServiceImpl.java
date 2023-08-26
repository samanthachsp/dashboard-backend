/**
 * 
 */
package com.dashboard.services.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.dashboard.common.RoleEnum;
import com.dashboard.common.UserGroupEnum;
import com.dashboard.dao.portal.UserAuthorizationRepository;
import com.dashboard.dao.portal.UserRepository;
import com.dashboard.exceptions.ValidationException;
import com.dashboard.model.portal.Role;
import com.dashboard.model.portal.User;
import com.dashboard.model.portal.UserAuthorization;
import com.dashboard.model.portal.UserGroup;
import com.dashboard.util.MessageSourceUtil;


/**
 * @author Samantha
 *
 */


@Service
public class UserServiceImpl implements UserService {
   
	@Autowired
	UserRepository service;
	
	@Autowired 
	UserAuthorizationRepository userAuthorizationService;
	
	@Autowired
	MessageSourceUtil messageSaurceUtil;
	
    @Autowired
    @Qualifier("portalEntityManager")
    private EntityManager entityManager;
    
	@Override
	public List<User> getUsers(String name) throws Exception {
		List<User> users = service.findUserByName(name);
		return users.stream().map(user -> {
			user.setPassword("");
			return user;
		}).collect(Collectors.toList());
	}
	
	
	@Override
	public User findUserById(String id) throws Exception {
		try {
			System.out.println("getUserSuppliers - " + id);
			User user = service.findUserById(id);
			user.setPassword("");
			return user;
		} catch (ValidationException e) {
			throw e;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
   
    
	
}
