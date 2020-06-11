package com.Sales_Modules;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Sales_Quotes_QuoteItems extends Base {

	public static void Add_Products(List<HashMap<String, String>> data) throws InterruptedException {

		WebdriverWait.findElement("link", "Quote Items").click();

		for (int p = 0; p <= 9; p++) {

			Thread.sleep(1000);
			WebdriverWait.findElement("name", "productId").sendKeys(data.get(p).get("Product ID"));

			Select uom_dd = new Select(WebdriverWait.findElement("id", "quantityUomId"));
			uom_dd.selectByVisibleText(data.get(p).get("UOM"));

			WebdriverWait.findElement("name", "quantity").sendKeys(data.get(p).get("Qty"));

			Select dept_dd = new Select(WebdriverWait.findElement("id", "departmentName"));
			dept_dd.selectByVisibleText(data.get(p).get("Dept"));

			Select fac_dd = new Select(WebdriverWait.findElement("id", "facilityId"));

			if (p <= 4) {
				fac_dd.selectByVisibleText(data.get(1).get("Facility-ShipGroup"));
				WebElement ATP = WebdriverWait.findElement("id", "ATP");
				WebElement QOH = WebdriverWait.findElement("id", "QOH");
				Assert.assertEquals(true, ATP.isDisplayed());
				Assert.assertEquals(true, QOH.isDisplayed());

			} else if (p >= 5 && p <= 7) {
				fac_dd.selectByVisibleText(data.get(6).get("Facility-ShipGroup"));
				WebElement ATP = WebdriverWait.findElement("id", "ATP");
				WebElement QOH = WebdriverWait.findElement("id", "QOH");
				Assert.assertEquals(true, ATP.isDisplayed());
				Assert.assertEquals(true, QOH.isDisplayed());
			} else if (p >= 8 && p <= 9) {
				fac_dd.selectByVisibleText(data.get(9).get("Facility-ShipGroup"));
				WebElement ATP = WebdriverWait.findElement("id", "ATP");
				WebElement QOH = WebdriverWait.findElement("id", "QOH");
				Assert.assertEquals(true, ATP.isDisplayed());
				Assert.assertEquals(true, QOH.isDisplayed());
			}

			WebElement price = WebdriverWait.findElement("id", "quoteUnitPrice");
			Assert.assertEquals(true, price.isDisplayed());
			WebdriverWait.findElement("name", "comments").sendKeys("SO QuoteTest");
			WebdriverWait.findElement("xpath", "//*[@id='createQuoteItem']/table/tbody[1]/tr[6]/td[2]/input").click();

		}

	}

}