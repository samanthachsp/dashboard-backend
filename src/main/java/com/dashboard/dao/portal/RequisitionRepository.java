package com.dashboard.dao.portal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dashboard.model.portal.Requisition;



@Repository
public interface RequisitionRepository extends JpaRepository<Requisition, Integer> {
	
	@Query(value="SELECT c.* FROM REQUISITION c WHERE YEAR(DateCreated)=:year and MONTH(DateCreated)=:month", nativeQuery = true)
	List<Requisition> findRequisitionByYM(String year, String month);
	
	@Query(value="SELECT c.* FROM REQUISITION c WHERE YEAR(DateCreated)=:year", nativeQuery = true)
	List<Requisition> findRequisitionByY(String year);
}

