package com.Sales_Modules;

import org.openqa.selenium.support.ui.Select;

import com.Utils.Base;
import com.Utils.ExcelWriter;
import com.Utils.WebdriverWait;

public class Sales_Quotes_Edit extends Base {

	public static void Capture_SO_QuoteID(String sheetname) {

		String quoteNum = WebdriverWait.findElement("xpath", "//*[@id='updateQuote']/div/table/tbody[1]/tr[1]/td[2]").getText();
		System.out.println("SO Quote ID = " + quoteNum);
		ExcelWriter.writeExcelFile(sheetname, 15, 2, quoteNum);

	}

	public static void SO_Accept_Quote() {

		WebdriverWait.findElement("link", "Edit").click();

		Select status_dd = new Select(WebdriverWait.findElement("id", "statusId"));
		status_dd.selectByVisibleText("Accept Quote");

		WebdriverWait.findElement("xpath", "//*[@id= 'updateQuote']/div/table/tbody[1]/tr[15]/td/input").click();

	}
}
