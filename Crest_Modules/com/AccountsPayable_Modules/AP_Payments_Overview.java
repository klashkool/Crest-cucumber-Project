package com.AccountsPayable_Modules;

import org.junit.Assert;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class AP_Payments_Overview extends Base {

	public static void ConfirmPayment() {

		WebdriverWait.findElement("link", "Confirm").click();

		String Pymt_Status = WebdriverWait
				.findElement("xpath", "//*[@id='content-main-section']/div[1]/div[2]/table/tbody[1]/tr[1]/td[4]")
				.getText();
		Assert.assertEquals("Confirmed", Pymt_Status);

		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[2]/td[3]/a")
				.click();// Click POnum
	}

}
