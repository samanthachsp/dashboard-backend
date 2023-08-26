package com.dashboard.dao.portal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dashboard.model.portal.Production;



@Repository
public interface ProductionRepository extends JpaRepository<Production, Integer> {
	
	@Query(value="SELECT c.* FROM Production c WHERE YEAR(DateCreated)=:year and MONTH(DateCreated)=:month", nativeQuery = true)
	List<Production> findProductionByYM(String year, String month);
	
	@Query(value="SELECT c.* FROM Production c WHERE YEAR(DateCreated)=:year", nativeQuery = true)
	List<Production> findProductionByY(String year);
}

