package com.cxb.cyj.util;

import java.text.DecimalFormat;

public class Customer {
	private static int totalCount = 0;
	private int customerID;

	public Customer() {
		++totalCount;
		customerID = totalCount;
		System.out.println("增加一个");
	}

	public String getCustomerID() {
		DecimalFormat decimalFormat = new DecimalFormat("200000199");
		return decimalFormat.format(customerID);
	}
}