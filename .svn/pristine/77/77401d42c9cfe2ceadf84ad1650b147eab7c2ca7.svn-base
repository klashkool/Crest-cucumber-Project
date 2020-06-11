package com.Sales_Modules;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Sales_Quotes_View extends Base {

	public static void Quote_Header_Val() {

		String quotesHeader = WebdriverWait.findElement("xpath", "//*[@id= 'content-messages']/div/p").getText();
		Assert.assertEquals("Quote updated successfully", quotesHeader);
		System.out.println("Quote Accepted Successfully");
	}

	public static void SO_Quotes_CreateOrderLink() {

		WebdriverWait.findElement("link", "Create Order");
	}

	public static void SO_Quotes_GrndTotal_Val(List<HashMap<String, String>> data) {

		String grdTotal = WebdriverWait.findElement("xpath", "//*[@id= 'content-main-section']/div[2]/div[2]/table/tbody/tr[12]/td[2]").getText()
						.replace("₹", "").replace(",", "");
		System.out.println(grdTotal);
		System.out.println(data.get(17).get("Dept"));
		Assert.assertEquals(data.get(17).get("Dept"), grdTotal);
	}

}
