package com.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.portal.Requisition;
import com.dashboard.services.RequisitionServiceImpl;

@RestController
@RequestMapping
public class RequisitionController {

	//TODO: Add validations
	//TODO: Verify edit and implement add
	@Autowired
	RequisitionServiceImpl requisitionService;
	
	@GetMapping("/v1.0/requisition")
	public ResponseEntity<List<Requisition>> getRequisitions(@RequestParam String year, @RequestParam String month) throws Exception {
		System.out.println(year + month);
		List<Requisition> requisitions = requisitionService.getRequisitions(year, month);
		return ResponseEntity.ok(requisitions);
	}
	

}
