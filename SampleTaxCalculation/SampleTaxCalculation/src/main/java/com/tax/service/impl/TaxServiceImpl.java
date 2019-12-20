package com.tax.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tax.model.RequestObject;
import com.tax.service.TaxService;

@Service
public  class TaxServiceImpl implements TaxService {
	 final double SALES_TAX_PERCENT = 0.1;
     final double ADDITIONAL_SALES_TAX_PERCENT = 0.05;



	  public Receipt generateReceipt(String[] inputs) {
	        List<Item> items = ItemFactory.from(inputs);
	        return new Receipt(items);
	    }
	   public  void applyTaxes(RequestObject obj) {
	        if (!obj.isExempted()) {
	        	obj.setBasicSalesTaxAmount(SALES_TAX_PERCENT);
	        }

	        if (obj.isImported()) {
	        	obj.setAdditionalSalesTax(ADDITIONAL_SALES_TAX_PERCENT);
	        }
	    }
}
