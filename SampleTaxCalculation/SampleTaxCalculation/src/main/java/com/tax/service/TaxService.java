package com.tax.service;

import com.tax.service.impl.Receipt;

public interface TaxService {

	 Receipt generateReceipt(String[] inputs);
}
