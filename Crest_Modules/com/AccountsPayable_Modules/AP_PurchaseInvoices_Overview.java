package com.AccountsPayable_Modules;

import org.junit.Assert;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class AP_PurchaseInvoices_Overview extends Base {

	public static void PI_Post() {

		WebdriverWait.findElement("link", "Post").click();

		String InvID_Status = WebdriverWait
						.findElement("xpath", "//*[@id='content-main-section']/div[1]/div[2]/table/tbody[1]/tr[7]/td[2]")
				.getText();
		Assert.assertEquals("Posted", InvID_Status);
	}

}
