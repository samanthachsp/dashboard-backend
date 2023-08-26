package com.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.model.portal.Production;
import com.dashboard.services.ProductionServiceImpl;

@RestController
@RequestMapping
public class ProductionController {

	//TODO: Add validations
	//TODO: Verify edit and implement add
	@Autowired
	ProductionServiceImpl productionService;
	
	@GetMapping("/v1.0/production")
	public ResponseEntity<List<Production>> getProductions(@RequestParam String year, @RequestParam String month) throws Exception {
		System.out.println(year + month);
		List<Production> productions = productionService.getProductions(year, month);
		return ResponseEntity.ok(productions);
	}
	

}
