package com.AccountsPayable_Modules;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class AP_PurchaseInvoices extends Base {

	public static Logger log = Logger.getLogger(AP_PurchaseInvoices.class);

	public static void InvoicePosting(List<HashMap<String, String>> data) throws InterruptedException {

		log.info("Validating and Posting all the Invoice ID's");
		int j = 14;
		for (int a = 1; a <= 4; a++) {

			WebdriverWait.findElement("link", "ACCOUNTS PAYABLE").click();
			WebdriverWait.findElement("link", "Purchase Invoices").click();
			WebdriverWait.findElement("id", "invoiceId").sendKeys(data.get(j).get("Currency"));
			WebdriverWait.findElement("xpath", "//*[@id='FindPurchaseInvoice']/table/tbody[1]/tr[7]/td/input").click();// Search
																														// Button
			WebdriverWait.findElement("xpath", "//*[@id= 'example']/tbody/tr/td[1]/a").click();
			AP_PurchaseInvoices_Header.PI_Approve();
			AP_PurchaseInvoices_Overview.PI_Post();
			// Button
			j++;
		}

		System.out.println("PO Invoice ID's Posted Successfully");
	}

}
