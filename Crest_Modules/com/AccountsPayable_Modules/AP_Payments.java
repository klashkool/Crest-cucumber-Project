package com.AccountsPayable_Modules;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;

import com.Procurement_Modules.Procurement_PurchaseOrder_View;
import com.Utils.Base;
import com.Utils.WebdriverWait;

public class AP_Payments extends Base {

	public static Logger log = Logger.getLogger(AP_Payments.class);


	public static void Payments(List<HashMap<String, String>> data, String sheetname) throws InterruptedException {

		log.info("Making Payments for all the Invoice ID");
		WebdriverWait.findElement("link", "ACCOUNTS PAYABLE").click();
		WebdriverWait.findElement("xpath", "//*[@id='app-navigation']//li[4]//a").click();// Payments link
		WebdriverWait.findElement("xpath", "//*[@id='searchContainer']//a").click();// Create Payments

		// Organization Dropdown
		Select Org_DD = new Select(WebdriverWait.findElement("id", "partyIdFrom"));
		Org_DD.selectByVisibleText(data.get(0).get("Organization"));

		// Payment Type Dropdown
		Select Paytype_DD = new Select(WebdriverWait.findElement("id", "paymentTypeId"));
		Paytype_DD.selectByVisibleText("Vendor Payment");

		// PartyID
		WebdriverWait.findElement("name", "partyIdTo").sendKeys("11680");// Nagarjuna
																			// Fertilizers

		// Account Dropdown
		Select Acct_DD = new Select(WebdriverWait.findElement("id", "paymentMethodId"));
		Acct_DD.selectByVisibleText("ICICI-2960");

		// Payment Method
		Select Paymethd_DD = new Select(WebdriverWait.findElement("id", "paymentMethod"));
		Paymethd_DD.selectByVisibleText("Cash");

		// Numbering Type
		Select NumType_DD = new Select(WebdriverWait.findElement("id", "numberingFormatId"));
		NumType_DD.selectByVisibleText("Payables Pay");

		// Currency
		Select Cur_DD = new Select(WebdriverWait.findElement("id", "currencyUomId"));
		Cur_DD.selectByVisibleText("INR");

		WebdriverWait
				.findElement("xpath", "//*[@id='content-main-section']/div/div[2]/form/table/tbody[1]/tr[8]/td/input")
				.click();

		AP_Payments_Header.PaymentIDCapture(sheetname);
		AP_Payments_Applications.SelectInvoiceID(data);
		AP_Payments_Overview.ConfirmPayment();
		Procurement_PurchaseOrder_View.InvID_PaymntStatus_Val();

	}
}
