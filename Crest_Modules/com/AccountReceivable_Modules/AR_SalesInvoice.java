package com.AccountReceivable_Modules;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.Sales_Modules.Sales_SalesOrder;
import com.Utils.Base;
import com.Utils.WebdriverWait;

public class AR_SalesInvoice extends Base {

	public static Logger log = Logger.getLogger(Sales_SalesOrder.class);

	public static void SO_InvoicePosting(List<HashMap<String, String>> data) {

		log.info("Validating and Posting all the Invoice ID's");
		int j = 14;
		for (int Inv = 1; Inv <= 4; Inv++) {

			WebdriverWait.findElement("link", "ACCOUNTS RECEIVABLE").click();
			WebdriverWait.findElement("link", "Sales Invoice").click();
			WebdriverWait.findElement("id", "invoiceId").sendKeys(data.get(j).get("Currency"));
			WebdriverWait.findElement("id", "submit").click();
			WebdriverWait.findElement("xpath", "//*[@id='example']/tbody/tr/td[1]/a").click();

			AR_SalesInvoice_Header.SO_Invoice_Approve();
			AR_SalesInvoice_Overview.SO_Invoice_Post();
			// AR_SalesInvoice_Overview.SO_Inv_AcctTrans_Val();
			j++;
		}

		System.out.println("SO Invoice ID's Posted Successfully");

	}

}
