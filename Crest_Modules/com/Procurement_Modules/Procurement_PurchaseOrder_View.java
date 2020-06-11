package com.Procurement_Modules;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.Crest_ERP_Login.Crest_Login;
import com.Utils.Base;
import com.Utils.ExcelWriter;
import com.Utils.WebdriverWait;

public class Procurement_PurchaseOrder_View extends Base {

	public static String po_Number;

	public static void POnum_Capture(String sheetname) {

		String PO_Num = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']//div//table//tbody//tr[1]//td[2]//a").getText();

		System.out.println("PO Number = " + PO_Num);
		po_Number = PO_Num;
		ExcelWriter.writeExcelFile(sheetname, 15, 3, PO_Num);

	}

	public static void PO_GrdTotal_Val(List<HashMap<String, String>> data) {

		log.info("Validating GrandTotal");
		String GrdTotal = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']//div//table//tbody//tr[14]//td[3]/span").getText()
						.replace("₹", "").replace(",", "");
		System.out.println(GrdTotal);
		System.out.println(data.get(18).get("Line Item Value"));
		Assert.assertEquals(data.get(18).get("Line Item Value"), GrdTotal);
		log.info("Grand Total & Tax Amt validated Successfully");
	}

	public static void PO_Approve() {

		log.info("Approve PO for Inv");
		WebdriverWait.findElement("link", "Review Order").click();
		WebdriverWait.findElement("link", "Review 2 Order").click();
		WebdriverWait.findElement("link", "Approve Order").click();
		String App_Status_Val = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[1]/div[2]/table/tbody/tr[5]/td[2]").getText();
		Assert.assertEquals("Approved", App_Status_Val);
		log.info("Status validated successfully as Approved");

	}

	public static void CaptureInvID(String sheetname) {

		log.info("Receiving Inventory for all the products");
		int j = 15;

		List<WebElement> InvTable = WebdriverWait.findElements("xpath", "//*[@id= 'content-main-section']/div[5]/div[2]/table/tbody");

		for (int Inv = 1; Inv <= InvTable.size(); Inv++) {

			String bpath = "//*[@id='content-main-section']/div[5]/div[2]/table/tbody[";
			String apath = "]/tr/td[1]";// Inv ID

			String InvID = WebdriverWait.findElement("xpath", bpath + Inv + apath).getText();

			ExcelWriter.writeExcelFile(sheetname, j, 5, InvID);
			j++;
		}
	}

	public static void InvID_PaymntStatus_Val() {

		List<WebElement> InvID_List = WebdriverWait.findElements("xpath", "//*[@id='content-main-section']/div[5]/div[2]/table/tbody/tr");
		System.out.println(InvID_List.size());

		for (int Inv = 1; Inv <= InvID_List.size(); Inv++) {
			String Inv_sts = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[5]/div[2]/table/tbody[" + Inv + "]/tr/td[4]").getText();
			Assert.assertEquals("Paid", Inv_sts);

		}

	}

	public static void PO_WFC_Approvals(List<HashMap<String, String>> data) {

		String GrndTotal = data.get(18).get("Sales Price");
		// String GrndTotal = "5000.45";
		 double f = Double.parseDouble(GrndTotal);
		 System.out.println(f);

		 if (f <= 10000.00) {

			String po_sts = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[5]/td[2]").getText();
			Assert.assertEquals("Approved", po_sts);

		 } else if (f > 10000.00 && f <= 50000.00) {

			String status = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[5]/td[2]").getText();
			Assert.assertEquals("Processing", status);

			List<WebElement> approvalTab = WebdriverWait.findElements("xpath", "//*[@id='list']/div[2]/ol/li");
			approvalTab.size();
			Assert.assertEquals(3, approvalTab.size());
			Crest_Login.PurchaseManager_login();
			PO_Multilevel_Approval();

		 } else if (f > 50000.00) {

			System.out.println("Grand Total is greater than 50000");

		String status = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[5]/td[2]").getText();
		Assert.assertEquals("Processing", status);

		List<WebElement> approvalTab = WebdriverWait.findElements("xpath", "//*[@id='list']/div[2]/ol/li");
		approvalTab.size();
		Assert.assertEquals(5, approvalTab.size());

		Crest_Login.PurchaseManager_login();
		PO_Multilevel_Approval();
		Crest_Login.PurchaseVP_login();
		PO_Multilevel_Approval();
		Crest_Login.PurchaseCEO_login();
		PO_Multilevel_Approval();

	}
	}
	public static void PO_Multilevel_Approval() {

		String notification = WebdriverWait.findElement("xpath", "//*[@id='masthead']/ul/li[3]/ul/li[1]/a/span").getText();
		int n = Integer.parseInt(notification);
		System.out.println(n);

		WebdriverWait.findElement("xpath", "//*[@id='masthead']/ul/li[3]/ul/li[1]/a").click();

		List<WebElement> notificationTable = WebdriverWait.findElements("xpath", "//*[@id='example']/tbody/tr");

		for (int a = 1; a <= notificationTable.size(); a++) {
			String poNum = WebdriverWait.findElement("xpath", "//*[@id='example']/tbody/tr[" + a + "]/td[4]/a").getText();
			if (poNum.contains(po_Number)) {
				WebdriverWait.findElement("xpath", "//*[@id='example']/tbody/tr[" + a + "]/td[4]/a").click();
				break;
			}
		}
		WebdriverWait.findElement("id", "workflowComments").sendKeys("Approved");
		WebdriverWait.findElement("link", "Approve").click();

		List<WebElement> approvalTab = WebdriverWait.findElements("xpath", "//*[@id='list']/div[2]/ol/li");
		approvalTab.size();

		// if (approvalTab.size() = 3 || approvalTab.size() == 5) {
		//
		// String notification1 = WebdriverWait.findElement("xpath",
		// "//*[@id='masthead']/ul/li[3]/ul/li[1]/a/span").getText();
		// int n1 = Integer.parseInt(notification1);
		// Assert.assertEquals(n , n1);
		// }else {
		// String notification1 = WebdriverWait.findElement("xpath",
		// "//*[@id='masthead']/ul/li[3]/ul/li[1]/a/span").getText();
		// int n1 = Integer.parseInt(notification1);
		// Assert.assertEquals(n - 1, n1);
		// }
	}

	public static void EditOrderLink() {

		WebdriverWait.findElement("link", "Edit Order").click();
	}

	public static void PO_GrdTotal_Val1(List<HashMap<String, String>> data, int row, String Header) {

		log.info("Validating GrandTotal");
		String GrdTotal = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']//div//table//tbody//tr[14]//td[3]/span").getText()
						.replace("₹", "").replace(",", "");
		System.out.println(GrdTotal);
		System.out.println(data.get(row).get(Header));
		Assert.assertEquals(data.get(row).get(Header), GrdTotal);
		log.info("Grand Total & Tax Amt validated Successfully");
	}
}
