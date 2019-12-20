package com.tax.service.impl;

import java.util.List;


public class TaxCalculatorApplication {


    Receipt generateReceipt(String[] inputs) {
        List<Item> items = ItemFactory.from(inputs);
        return new Receipt(items);
    }
}
