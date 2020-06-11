package com.Sales_Modules;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.Utils.Base;
import com.Utils.ExcelWriter;
import com.Utils.WebdriverWait;

public class Sales_SalesOrder_View extends Base {


	public static String so_Number;

	public static void Capture_SONum(String sheetname) {

		String so_Num = WebdriverWait
				.findElement("xpath", "//*[@id='content-main-section']/div[1]/div[2]/table/tbody/tr[1]/td[2]/a")
				.getText();
		System.out.println("SO Number = " + so_Num);
		so_Number = so_Num;
		ExcelWriter.writeExcelFile(sheetname, 15, 3, so_Num);

	}

	public static void SO_GrdTotal_Val(List<HashMap<String, String>> data) {

		log.info("Validating GrandTotal");
		String GrdTotal = WebdriverWait
				.findElement("xpath", "//*[@id='content-main-section']/div[6]/div[2]/table/tbody/tr[14]/td[3]/span")
				.getText().replace("₹", "").replace(",", "");
		System.out.println(GrdTotal);
		System.out.println(data.get(18).get("Sales Price"));
		Assert.assertEquals(data.get(18).get("Sales Price"), GrdTotal);
		log.info("Grand Total & Tax Amt validated Successfully for SO Normal Flow");
	}

	public static void Approve_SO() {

		log.info("Approve SO Normal Flow");

		WebdriverWait.findElement("link", "Approve Order").click();
		String App_Status_Val = WebdriverWait
				.findElement("xpath", "//*[@id='content-main-section']//div//table//tbody//tr[11]//td[2]").getText();
		Assert.assertEquals("Approved", App_Status_Val);
		log.info("Status validated successfully as Approved");
	}

	public static void SO_CaptureInvID(String sheetname) {

		log.info("Capturing Invoice ID's for all the Shipments");
		int j = 15;
		for (int Inv = 1; Inv <= 4; Inv++) {

			String InvID = WebdriverWait
					.findElement("xpath", "//*[@id='content-main-section']//div//tr//td[6]//a[" + Inv + "]").getText();

			ExcelWriter.writeExcelFile(sheetname, j, 5, InvID);
			j++;
		}
	}

	public static void InvID_PaymntStatus_Val(List<HashMap<String, String>> data) {

		WebdriverWait.findElement("link", "SALES").click();
		WebdriverWait.findElement("link", "Sales Order").click();
		WebdriverWait.findElement("id", "orderId").sendKeys(data.get(14).get("Customer"));
		WebdriverWait.findElement("xpath", "//*[@id= 'searchCriteria']/div/table/tbody[1]/tr[16]/td/input").click();
		WebdriverWait.findElement("xpath", "//*[@id='example']/tbody/tr/td[2]/a").click();

		List<WebElement> InvID_List = WebdriverWait.findElements("xpath", "//*[@id= 'content-main-section']/div[4]/div[2]/table/tbody/tr/td[6]/a");
		System.out.println(InvID_List.size());

		for (int Inv = 1; Inv <= InvID_List.size(); Inv++) {

			WebdriverWait.findElement("xpath", "//*[@id= 'content-main-section']/div[4]/div[2]/table/tbody/tr/td[6]/a[" + Inv + "]").click();

			String Inv_sts = WebdriverWait.findElement("xpath", "//*[@id= 'content-main-section']/div[2]/div[2]/table/tbody[1]/tr[8]/td[2]").getText();
			Assert.assertEquals("Paid", Inv_sts);

			WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[6]/div[2]/table/tbody/tr[1]/td[1]/a").click();

		}
	}
}