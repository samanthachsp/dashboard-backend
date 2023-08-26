package com.dashboard.services;

import java.util.List;

import com.dashboard.model.portal.Production;


public interface ProductionService {
	
	/**
	 * @return all the stock
	 */
//	public List<Production> getProductions(String storeId) throws Exception;
	
	public List<Production> getProductions(String year, String month) throws Exception;

}
