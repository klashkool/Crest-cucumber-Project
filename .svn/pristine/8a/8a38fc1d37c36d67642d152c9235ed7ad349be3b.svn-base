package com.AccountReceivable_Modules;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.Sales_Modules.Sales_SalesOrder;
import com.Utils.Base;
import com.Utils.WebdriverWait;

public class AR_SalesInvoice_Overview extends Base {

	public static Logger log = Logger.getLogger(Sales_SalesOrder.class);

	public static void SO_Invoice_Post() {

		WebdriverWait.findElement("link", "Post").click();
		String so_invId_status = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']//div//tr[8]/td[2]")
				.getText();
		Assert.assertEquals("Posted", so_invId_status);
	}

	public static void SO_Inv_AcctTrans_Val() {

		List<WebElement> transTable = WebdriverWait.findElements("xpath",
				"//*[@id='content-main-section']//div[8]//tr");

		for (int a = 1; a <= transTable.size() - 1; a++) {

			String acctName = WebdriverWait
					.findElement("xpath", "//*[@id='content-main-section']//div[8]//tr[" + a + "]//td[11]").getText();

			if (acctName.equalsIgnoreCase("GENERAL SALES") & acctName.equalsIgnoreCase(("Input CGST"))) {
				String flag = WebdriverWait
						.findElement("xpath", "//*[@id='content-main-section']//div[8]//tr[" + a + "]//td[12]")
						.getText();
				Assert.assertEquals("C", flag);
			} else if (acctName.equalsIgnoreCase("Accounts Receivable")) {
				String flag = WebdriverWait
						.findElement("xpath", "//*[@id='content-main-section']//div[8]//tr[" + a + "]//td[12]")
						.getText();
				Assert.assertEquals("D", flag);
			}
		}
		System.out.println("Invoice Accounting Transactions Validated Succesfully with Debit/Credit Flag");
	}
}