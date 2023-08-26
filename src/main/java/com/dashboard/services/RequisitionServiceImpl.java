/**
 * 
 */
package com.dashboard.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.dashboard.dao.portal.RequisitionRepository;
import com.dashboard.model.portal.Requisition;
import com.dashboard.util.MessageSourceUtil;



/**
 * @author Samantha
 *
 */


@Service
public class RequisitionServiceImpl implements RequisitionService {

    @Autowired
    private MessageSource messageSource;
	
    @Autowired
    @Qualifier("portalEntityManager")
    private EntityManager entityManager;
    
	@Autowired
	RequisitionRepository service;
	
	@Autowired
	MessageSourceUtil messageSaurceUtil;
	
	
	@Override
	public List<Requisition> getRequisitions(String year, String month) throws Exception {
		if(year != null && !year.isEmpty() && (month != null && !month.isEmpty())) {
			return service.findRequisitionByYM(year, month);
		} else if(year != null && !year.isEmpty()) {
			return service.findRequisitionByY(year);
		}
		return new ArrayList<Requisition>();
	}
	

}
