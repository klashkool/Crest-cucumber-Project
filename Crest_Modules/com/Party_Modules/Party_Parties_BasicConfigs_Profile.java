package com.Party_Modules;

import java.util.HashMap;
import java.util.List;

import com.Utils.ExcelWriter;
import com.Utils.WebdriverWait;

public class Party_Parties_BasicConfigs_Profile {

	public static void Capture_BillingAcct_Bal(String sheetname) {

		WebdriverWait.findElement("xpath", "//*[@id='partyPaymentMethod']//td//a").click();

		String availBal = WebdriverWait.findElement("xpath", "//*[@id='updateBillingAccount']//tr[6]//td[2]").getText().replace("₹", "").replace(",", "");
		ExcelWriter.writeExcelFile(sheetname, 15, 12, availBal);

	}

	public static void Val_BillingAcct_Bal(List<HashMap<String, String>> data, String sheetname) {

		WebdriverWait.findElement("xpath", "//*[@id='partyPaymentMethod']//td//a").click();

		System.out.println(data.get(14).get("Taxable"));

		String billingAcctBal = data.get(14).get("Taxable");
		// double billingAcctbal =

		// System.out.println(billingAcctbal);

		String grandTotalBal = data.get(18).get("Sales Price");
		// Float grandTotalbal = Float.parseFloat(grandTotalBal);

		// System.out.println(grandTotalbal);

		// double result = billingAcctBal - grandTotalBal;
		// System.out.println(result);
		//
		// String availBal = WebdriverWait.findElement("xpath",
		// "//*[@id='updateBillingAccount']//tr[6]//td[2]").getText().replace("₹",
		// "").replace(",", "");
		// Assert.assertEquals(result, availBal);

	}
}
