package com.Crest_Scenarios_TestRunner;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Misterlight_InvPrice_Change extends Base {

	public static void ML_PriceUpdate(List<HashMap<String, String>> data) {

		WebdriverWait.findElement("link", "FACILITY").click();
		WebdriverWait.findElement("link", "Facilities").click();

		Select fac_dd = new Select(WebdriverWait.findElement("name", "facilityId"));
		fac_dd.selectByVisibleText("NIP");

		WebdriverWait.findElement("name", "selectButton").click();

		for (int a = 2410; a <= 2520; a++) {

			System.out.println("S.no = "+ a);
			WebdriverWait.findElement("link", "Inventory Items").click();
			WebdriverWait.findElement("name", "inventoryItemId").sendKeys(data.get(a).get("Inventory Item Id"));
			System.out.println("Inv ID = " + data.get(a).get("Inventory Item Id"));

			WebdriverWait.findElement("name", "submitButton").click();

			WebdriverWait.findElement("xpath", "//*[@id='search-results']/table/tbody/tr/td[1]/a").click();

			WebdriverWait.findElement("name", "unitCost").clear();
			WebdriverWait.findElement("name", "unitCost").sendKeys(data.get(a).get("UnitCost"));

			WebdriverWait.findElement("name", "submit").click();

			String value = WebdriverWait.findElement("name", "unitCost").getAttribute("value");
			System.out.println("unitcost = " + value);
			Assert.assertEquals(value, data.get(a).get("UnitCost"));

		}

	}
}