package com.Facilities_Modules;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.Sales_Modules.Sales_SalesOrder;
import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Facilities_Shipments_OrderItems extends Base {

	public static Logger log = Logger.getLogger(Sales_SalesOrder.class);

	public static void SO_Partial_Shpmnt() {

		WebdriverWait.findElement("link", "Order Items").click();
		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']//div//tr[3]//td//input").click();

		WebdriverWait.findElement("name", "selectAll").click();
		List<WebElement> Shpqty_List = WebdriverWait.findElements("xpath", "//*[@id='form']//tr");
		System.out.println(Shpqty_List.size());
		for (int a = 2; a <= Shpqty_List.size(); a++) {
			String PrdId = WebdriverWait.findElement("xpath", "//*[@id='form']//tr[" + a + "]//td[2]").getText();

			if (PrdId.equalsIgnoreCase("1 X 20W BATTEN LIGHT FITTING, DANPEX [DNPFT001]")) {

				WebdriverWait.findElement("name", "quantity_o_" + (a - 2)).clear();
				WebdriverWait.findElement("name", "quantity_o_" + (a - 2)).sendKeys("900");

			}
		}
		WebdriverWait.findElement("id", "submitButton").click();
	}

	public static void SO_Full_Shpmnt() {

		WebdriverWait.findElement("link", "Order Items").click();
		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']//div//tr[3]//td//input").click();
		WebdriverWait.findElement("name", "selectAll").click();
		WebdriverWait.findElement("id", "submitButton").click();
	}

	public static void PO_Partial_Shpmnt() throws InterruptedException {

		WebdriverWait.findElement("link", "Order Items").click();
		Thread.sleep(1000);
		WebdriverWait.findElement("xpath", "//*[@id='FindOrderItems']/table/tbody/tr[3]/td/input").click();

		List<WebElement> Shpqty_List = WebdriverWait.findElements("xpath", "//*[@id='AddOrderItems']/table/tbody/tr");
		System.out.println(Shpqty_List.size());
		for (int a = 2; a <= Shpqty_List.size(); a++) {
			String PrdId = WebdriverWait.findElement("xpath", "//*[@id='AddOrderItems']/table/tbody/tr[" + a + "]/td[4]").getText();

			if (PrdId.equalsIgnoreCase("DNPFT001 / 1 X 20W BATTEN LIGHT FITTING, DANPEX")) {
				WebdriverWait.findElement("id", "quantity_o_" + (a - 2)).clear();
				WebdriverWait.findElement("id", "quantity_o_" + (a - 2)).sendKeys("900");
			}
		}
		WebdriverWait.findElement("xpath", "//*[@id='AddOrderItems']/div/input").click();
		Facilities_Shipments_Adjustments.Adj();

	}

	public static void PO_Full_Shpmnt() {

		WebdriverWait.findElement("link", "Order Items").click();
		WebdriverWait.findElement("xpath", "//*[@id='FindOrderItems']/table/tbody/tr[3]/td/input").click();
		WebdriverWait.findElement("xpath", "//*[@id='AddOrderItems']/div/input").click();
		Facilities_Shipments_Adjustments.Adj();
	}
}
