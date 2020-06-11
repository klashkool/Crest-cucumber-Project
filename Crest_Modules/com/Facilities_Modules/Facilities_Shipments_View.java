package com.Facilities_Modules;

import org.junit.Assert;

import com.Utils.Base;
import com.Utils.ExcelWriter;
import com.Utils.WebdriverWait;

public class Facilities_Shipments_View extends Base {

	public static void Shpmnt_Status_Val() {

		String shipStatus = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']//tr//td[4]").getText();
		Assert.assertEquals("Shipped", shipStatus);
	}

	public static void PO_Capture_ShpID(String sheetname, int row) {

		String shipID = WebdriverWait
				.findElement("xpath", "//*[@id='content-main-section']/div[2]/div[2]/table/tbody/tr[1]/td[2]")
				.getText();
		ExcelWriter.writeExcelFile(sheetname, row, 4, shipID);

	}

	public static void PO_Shpmnt_Status_Val() {

		String shipStatus = WebdriverWait
				.findElement("xpath", "//*[@id='content-main-section']/div[2]/div[2]/table/tbody/tr[2]/td[4]")
				.getText();
		Assert.assertEquals("Received", shipStatus);
	}

}
