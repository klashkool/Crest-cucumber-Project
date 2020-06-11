package com.AccountReceivable_Modules;

import org.apache.log4j.Logger;

import com.Sales_Modules.Sales_SalesOrder;
import com.Utils.Base;
import com.Utils.WebdriverWait;

public class AR_SalesInvoice_Header extends Base {

	public static Logger log = Logger.getLogger(Sales_SalesOrder.class);

	public static void SO_Invoice_Approve() {

		WebdriverWait.findElement("id", "referenceNumber").sendKeys("1234");
		WebdriverWait.findElement("link", "Update").click();
		WebdriverWait.findElement("link", "Approve").click();
	}
}
