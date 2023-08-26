package com.dashboard.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.dashboard.model.portal.User;
import com.dashboard.model.portal.UserGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class UserServiceImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    @JsonIgnore
    private String password;
    
    private Map<String, String> authorizations;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserServiceImpl build(User user, List<SimpleGrantedAuthority> authorities, StaticData staticData) {
//        StaticData staticData = new StaticDataUtil().getStaticData();
        List<UserGroup> groups = staticData.getGroups();
        
        Map<String, String> authorizations = new HashMap<String, String>();
        
        return new UserServiceImpl(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                authorizations,
                authorities
            );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserServiceImpl user = (UserServiceImpl) o;
        return Objects.equals(id, user.id);
    }
}
