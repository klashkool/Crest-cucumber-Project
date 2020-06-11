package com.Facilities_Modules;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;

import com.Sales_Modules.Sales_SalesOrder;
import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Facilities_Shipments_Edit extends Base {

	public static Logger log = Logger.getLogger(Sales_SalesOrder.class);

	public static void ShpStatus() throws InterruptedException {

		WebdriverWait.findElement("link", "Edit").click();

		Select status_dd1 = new Select(WebdriverWait.findElement("id", "statusId"));
		status_dd1.selectByVisibleText("Picked");
		Thread.sleep(1000);
		WebdriverWait.findElement("id", "submitForm").click();
		Thread.sleep(1000);

		Select status_dd2 = new Select(WebdriverWait.findElement("id", "statusId"));
		status_dd2.selectByVisibleText("Packed");
		Thread.sleep(1000);
		WebdriverWait.findElement("id", "submitForm").click();
		Thread.sleep(1000);

		Select status_dd3 = new Select(WebdriverWait.findElement("id", "statusId"));
		status_dd3.selectByVisibleText("Shipped");
		Thread.sleep(1000);
		WebdriverWait.findElement("id", "submitForm").click();
		Thread.sleep(1000);

		Facilities_Shipments_View.Shpmnt_Status_Val();

		WebdriverWait.findElement("xpath", "//*[@id='primaryOrderIdRowAndPrimaryShipGroupSeqId']/td[2]/a").click();
		log.info("All Qty Shipped successfully");
	}

}
