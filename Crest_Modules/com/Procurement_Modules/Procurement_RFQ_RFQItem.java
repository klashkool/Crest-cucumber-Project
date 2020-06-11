package com.Procurement_Modules;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Procurement_RFQ_RFQItem extends Base {

	public static void RFQ_Status_Val() {

		String rfq_status = WebdriverWait.findElement("xpath", "//*[@id='content-messages']/div/p").getText();
		Assert.assertEquals("RFQ Created Successfully", rfq_status);
		System.out.println("RFQ Created Successfully");
	}

	public static void RFQ_LoadItems(List<HashMap<String, String>> data) {

		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/form[1]/div[2]/input").click(); // Add Items

		String additems_valmsg = WebdriverWait.findElement("xpath", "//*[@id='content-messages']/div/p").getText();
		Assert.assertEquals("Item(s) Added Successfully to the RFQ", additems_valmsg);
	}

}
