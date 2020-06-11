package com.Facilities_Modules;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.Utils.Base;
import com.Utils.CrestTestDataReader;
import com.Utils.WebdriverWait;

public class Facilities_ReceiveAdHoc extends Base {

	public static Logger log = Logger.getLogger(Facilities_Shipments.class);

	List<HashMap<String, String>> PO_Inv_Adhoc_data = CrestTestDataReader.getPOInvAdhocData();

	// Scenario : Receive Adhoc Products

	public static void PO_Adhoc_Recv_PartialShpmt(List<HashMap<String, String>> data) {

		WebdriverWait.findElement("link", "Receive Ad Hoc").click();
		WebdriverWait.findElement("id", "0_lookupId_purchaseOrderId").sendKeys(data.get(14).get("Supplier"));
		WebdriverWait.findElement("link", "Get Details").click();

		List<WebElement> adhocqty_List = WebdriverWait.findElements("xpath", "//*[@id='selectAllForm']/div/table[2]/tbody/tr");
		System.out.println(adhocqty_List.size());
		for (int a = 2; a <= adhocqty_List.size(); a++) {
			String Prdname = WebdriverWait.findElement("xpath", "//*[@id='selectAllForm']/div/table[2]/tbody/tr[" + a + "]/td[3]").getText();

			if (Prdname.equalsIgnoreCase("Paper Cups")) {
				WebdriverWait.findElement("name", "remainingQty_o_" + (a - 2)).clear();
				WebdriverWait.findElement("name", "remainingQty_o_" + (a - 2)).sendKeys("2500");
			}
		}
		WebdriverWait.findElement("link", "Receive").click();

	}

	public static void PO_Adhoc_Recv_FullShpmt(List<HashMap<String, String>> data) {

		WebdriverWait.findElement("link", "Receive Ad Hoc").click();
		WebdriverWait.findElement("id", "0_lookupId_purchaseOrderId").sendKeys(data.get(14).get("Supplier"));
		WebdriverWait.findElement("link", "Get Details").click();
		WebdriverWait.findElement("link", "Receive").click();
	}
}
