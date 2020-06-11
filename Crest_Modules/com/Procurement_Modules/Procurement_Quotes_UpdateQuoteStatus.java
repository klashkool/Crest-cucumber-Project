package com.Procurement_Modules;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Procurement_Quotes_UpdateQuoteStatus extends Base {

	public static void UpdateQuoteStatus() {

		WebdriverWait.findElement("link", "Update Quote Status").click();

		List<WebElement> lineItems = WebdriverWait.findElements("xpath", "//*[@id='content-main-section']/div[1]/div[2]/table/tbody/tr");

		for (int a = 1; a <= lineItems.size(); a++) {

			Select status_dd = new Select(WebdriverWait.findElement("xpath", "//*[starts-with(@id, 'statusId_')]"));
			status_dd.selectByVisibleText("Fully Accepted");

			WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[1]/div[2]/table/tbody/tr[" + a + "]/td[13]/form/a").click();

		}

		WebdriverWait.findElement("link", "Create Order").click();
	}

}