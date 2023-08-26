package com.dashboard.services;

import java.util.List;

import com.dashboard.model.portal.Requisition;


public interface RequisitionService {
	
	/**
	 * @return all the stock
	 */
//	public List<Requisition> getRequisitions(String storeId) throws Exception;
	
	public List<Requisition> getRequisitions(String year, String month) throws Exception;

}
