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

import com.dashboard.dao.portal.ProductionRepository;
import com.dashboard.model.portal.Production;
import com.dashboard.util.MessageSourceUtil;



/**
 * @author Samantha
 *
 */


@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private MessageSource messageSource;
	
    @Autowired
    @Qualifier("portalEntityManager")
    private EntityManager entityManager;
    
	@Autowired
	ProductionRepository service;
	
	@Autowired
	MessageSourceUtil messageSaurceUtil;
	
	
	@Override
	public List<Production> getProductions(String year, String month) throws Exception {
		if(year != null && !year.isEmpty() && (month != null && !month.isEmpty())) {
			return service.findProductionByYM(year, month);
		} else if(year != null && !year.isEmpty()) {
			return service.findProductionByY(year);
		}
		return new ArrayList<Production>();
	}
	

}
