package com.AccountsPayable_Modules;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class AP_PurchaseInvoices_Header extends Base {

	public static void PI_Approve() throws InterruptedException {

		Thread.sleep(1000);
		WebdriverWait.findElement("id", "referenceNumber").sendKeys("1234");
		WebdriverWait.findElement("link", "Update").click();
		WebdriverWait.findElement("link", "Approve").click();
	}
}