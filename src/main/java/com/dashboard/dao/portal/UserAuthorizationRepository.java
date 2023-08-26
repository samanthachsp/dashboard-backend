package com.dashboard.dao.portal;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.common.RoleEnum;
import com.dashboard.model.portal.User;
import com.dashboard.model.portal.UserAuthorization;

@Repository
public interface UserAuthorizationRepository extends JpaRepository<UserAuthorization, Integer> {
	
	static final String VIEW_ROLE = RoleEnum.ROLE_VIEW.toString();
//    
//	@Query(value="SELECT c.* FROM User c WHERE c.username LIKE :name", nativeQuery = true)
//	List<UserAuthorization> findUserByName(@Param("name") String name);
//	
//	@Query(value="SELECT c.* FROM User c WHERE c.username LIKE :name", nativeQuery = true)
//	List<UserAuthorization> findUserLike(@Param("name") String name);
//	
//	@Query(value="SELECT c.* FROM User c WHERE c.username LIKE :id", nativeQuery = true)
//	UserAuthorization findUserById(@Param("id") String id);
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO user_authorization(user_id, group_id, role_id) \r\n"
			+ "select :id as user_id,id as group_id, (select id from roles where name=:role) as  role_id from groups where name='SHOP_USER' or name='STORES_USER' or name='SUPPLY_USER' or name='ACCOUNT_USER' or name='ESTIMATE_USER' or name='WORKSBRANCH_USER' or name='TIME_CLERK' ;", nativeQuery = true)
	void updateAuditorAutorizations(@Param("id") String id, @Param("role") String role);

    List<UserAuthorization> findByIdGreaterThan(int id);

	
}
