package com.Procurement_Modules;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.support.ui.Select;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Procurement_PurchaseReturn extends Base {

	public static void PO_Return(List<HashMap<String, String>> data, String sheetname) {

		WebdriverWait.findElement("link", "PROCUREMENT").click();
		WebdriverWait.findElement("link", "Purchase Returns").click();
		WebdriverWait.findElement("link", "Create Purchase Return").click();

		// Organization DD
		Select OrgDD = new Select(WebdriverWait.findElement("id", "fromPartyId"));
		OrgDD.selectByVisibleText(data.get(0).get("Organization"));

		// PartyID
		WebdriverWait.findElement("id", "0_lookupId_toPartyId").sendKeys("11680");// Nagarjuna
																					// Fertilizers

		// Adding Current Date(From Date)
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String Fromdate = (dateFormat.format(new Date()));
		WebdriverWait.findElement("name", "entryDate_i18n").sendKeys(Fromdate);

		// Facility DD
		Select FacDD = new Select(WebdriverWait.findElement("id", "destinationFacilityId"));
		FacDD.selectByVisibleText(data.get(9).get("Facility-ShipGroup"));

		// Currency DD
		Select CurrencyDD = new Select(WebdriverWait.findElement("id", "currencyUomId"));
		CurrencyDD.selectByVisibleText(data.get(0).get("Currency"));

		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/form/div/div[2]/div/input").click();

		Procurement_PurchaseReturn_ReturnHeader.Capture_ReturnID(sheetname);
		Procurement_PurchaseReturn_ReturnItems.Update_ReturnItems(data);
		Procurement_PurchaseReturn_ReturnHeader.Update_ReturnHeader();
	}

}