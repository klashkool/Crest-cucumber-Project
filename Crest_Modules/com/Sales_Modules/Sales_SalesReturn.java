package com.Sales_Modules;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.support.ui.Select;

import com.Utils.WebdriverWait;

public class Sales_SalesReturn {

	public static void Sales_Return(List<HashMap<String, String>> data, String sheetname) {

		WebdriverWait.findElement("link", "SALES").click();
		WebdriverWait.findElement("link", "Sales Return").click();
		WebdriverWait.findElement("link", "Create Sales Return").click();

		WebdriverWait.findElement("id", "0_lookupId_fromPartyId").sendKeys("11651");

		// Adding Current Date(From Date)

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String Fromdate = (dateFormat.format(new Date()));
		WebdriverWait.findElement("name", "entryDate_i18n").sendKeys(Fromdate);

		Select fac_dd = new Select(WebdriverWait.findElement("id", "destinationFacilityId"));
		fac_dd.selectByVisibleText(data.get(1).get("Facility-ShipGroup"));

		Select curr_dd = new Select(WebdriverWait.findElement("id", "currencyUomId"));
		curr_dd.selectByVisibleText(data.get(0).get("Currency"));

		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/form/div/div[2]/div/input").click();
		Sales_SalesReturn_ReturnHeader.Capture_ReturnID(sheetname);
		Sales_SalesReturn_ReturnItems.Return_items(data);
		Sales_SalesReturn_ReturnHeader.Update_ReturnHeader();
	}

}
