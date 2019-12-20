package com.tax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tax.model.RequestObject;
import com.tax.service.TaxService;
import com.tax.service.impl.Receipt;

@RestController
@RequestMapping("/api")
public class TaxController {

	@Autowired
	TaxService service;
	
	@RequestMapping("/taxcalculation")
	public Receipt getTaxCalculation(@RequestBody RequestObject inputs)
	{
		return service.generateReceipt((String[]) inputs.getInput().toArray());
		
	}
}
