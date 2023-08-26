package com.dashboard.dao.portal;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dashboard.model.portal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    
    Optional<User> findById(Integer id);

    Boolean existsByUsername(String username);
    
	@Query(value="SELECT c.* FROM User c WHERE c.username LIKE :name", nativeQuery = true)
	List<User> findUserByName(@Param("name") String name);
	
	@Query(value="SELECT c.* FROM User c WHERE c.username LIKE :name", nativeQuery = true)
	List<User> findUserLike(@Param("name") String name);
	
	@Query(value="SELECT c.* FROM User c WHERE c.id=:id", nativeQuery = true)
	User findUserById(@Param("id") String id);

    List<User> findByIdGreaterThan(int id);
	
	@Query(value="select * from user where id IN(SELECT distinct(ua.user_id) as id FROM group_notification_type gnt inner join user_authorization ua on ua.group_id = gnt.group_id  and ua.role_id=gnt.role_id" +
			" where notification_type_id=:id)", nativeQuery = true)
	List<User> findUserByNotificationType(@Param("id") Integer id);
	
}
