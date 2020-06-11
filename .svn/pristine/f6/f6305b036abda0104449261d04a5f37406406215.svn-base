package com.AccountReceivable_Modules;

import com.Utils.Base;
import com.Utils.ExcelWriter;
import com.Utils.WebdriverWait;

public class AR_Receipts_Header extends Base {

	public static void PaymentIDCapture(String sheetname) {

		String PayID = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div/div[2]/form/table/tbody[1]/tr[1]/td[2]").getText();
		ExcelWriter.writeExcelFile(sheetname, 15, 7, PayID);
	}

}
