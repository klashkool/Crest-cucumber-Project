package com.Sales_Modules;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Sales_SalesReturn_ReturnItems extends Base {

	public static void Return_items(List<HashMap<String, String>> data) {

		WebdriverWait.findElement("link", "Return Items").click();

		// Adding Current Date(From Date)
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String Fromdate = (dateFormat.format(new Date()));

		System.out.println(data.get(14).get("Customer") + " - " + Fromdate);

		Select orderId_DD = new Select(WebdriverWait.findElement("name", "orderId"));
		orderId_DD.selectByVisibleText(data.get(14).get("Customer") + " - " + Fromdate);

		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[1]/div[2]/form/table/tbody/tr[2]/td/input").click();

		List<WebElement> Returntble = WebdriverWait.findElements("xpath", "//*[@id= 'content-main-section']/form/div[1]/div[2]/table/tbody/tr");
		System.out.println(Returntble.size());

		for (int a = 0; a <= Returntble.size() - 2; a++) {

			String prdID = WebdriverWait.findElement("xpath", "//*[@id='returnItemId_tableRow_" + a + "']/td[1]").getText();
			System.out.println(prdID);

			if (prdID.equalsIgnoreCase(data.get(0).get("Product ID"))) {

				WebdriverWait.findElement("name", "returnQuantity_o_" + a).clear();
				WebdriverWait.findElement("name", "returnQuantity_o_" + a).sendKeys(data.get(22).get("Sales Price"));

				Select reason_DD = new Select(WebdriverWait.findElement("name", "returnReasonId_o_0"));
				reason_DD.selectByVisibleText(data.get(22).get("3ShpQty"));

				Select type_DD = new Select(WebdriverWait.findElement("name", "returnTypeId_o_0"));
				type_DD.selectByVisibleText(data.get(22).get("4ShpQty"));

				Select itemStatus_DD = new Select(WebdriverWait.findElement("name", "expectedItemStatus_o_0"));
				itemStatus_DD.selectByVisibleText(data.get(22).get("1ShpVal"));

				WebdriverWait.findElement("name", "_rowSubmit_o_" + a).click();
			}
		}
		WebdriverWait.findElement("id", "sub1").click();
		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[2]/div[2]/form[2]/div/input").click();
	}
	}


