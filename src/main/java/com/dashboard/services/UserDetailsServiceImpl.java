package com.dashboard.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dashboard.dao.portal.UserRepository;
import com.dashboard.model.portal.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    StaticData staticData;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	try {
    		User user = userRepository.findUserByName(username).get(0);
    		
            List<String> roles = new ArrayList<>();
            //get roles from userGroup
//            user.getUserAuthorizations().stream().forEach(group -> roles.add(group.getRole().getName()));
            //get roles from userRoles
//            user.getUserRoles().stream().forEach(role -> roles.add(role.getName()));
            List<SimpleGrantedAuthority> grantedAuthorities = roles.stream().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList()); // (1)

            return UserServiceImpl.build(user, grantedAuthorities, staticData);
    	} catch (Exception e) {
    		throw new UsernameNotFoundException("User details Not Found with username: " + username);
    	}


    }
}
