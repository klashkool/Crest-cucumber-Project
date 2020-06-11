package com.AccountReceivable_Modules;

import org.junit.Assert;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class AR_Receipts_Overview extends Base {

	public static void ConfirmPayment() {

		WebdriverWait.findElement("link", "Confirm").click();

		String Pymt_Status = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[2]/div[2]/table/tbody[1]/tr[2]/td[4]").getText();
		Assert.assertEquals("Confirmed", Pymt_Status);

		// WebdriverWait.findElement("xpath",
		// "//*[@id='content-main-section']/div[4]/div[2]/table/tbody/tr[2]/td[3]/a").click();//
		// Click
																																// SOnum
	}

}
