package com.dashboard.dao.portal;

import com.dashboard.common.RoleEnum;
import com.dashboard.model.portal.Role;
import com.dashboard.model.portal.UserGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
    Optional<UserGroup> findByName(RoleEnum name);

}
