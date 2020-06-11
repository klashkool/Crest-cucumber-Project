package com.AccountReceivable_Modules;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.support.ui.Select;

import com.Sales_Modules.Sales_SalesOrder_View;
import com.Utils.Base;
import com.Utils.WebdriverWait;

public class AR_Receipts extends Base {

	public static void Receipts(List<HashMap<String, String>> data, String sheetname) throws InterruptedException {

		log.info("Receiving Payments for all the Invoice ID");
		WebdriverWait.findElement("link", "ACCOUNTS RECEIVABLE").click();
		WebdriverWait.findElement("link", "Receipts").click();// Receipts link
		WebdriverWait.findElement("link", "Create Payment").click();// Create
																	// Payments

		// Organization Dropdown
		Select Org_DD = new Select(WebdriverWait.findElement("id", "partyIdTo"));
		Org_DD.selectByVisibleText(data.get(0).get("Organization"));

		// Payment Type Dropdown
		Select Paytype_DD = new Select(WebdriverWait.findElement("id", "paymentTypeId"));
		Paytype_DD.selectByVisibleText("Customer Payment");

		// PartyID
		WebdriverWait.findElement("name", "partyIdFrom").sendKeys("11651");// Workphilia

		// Account Dropdown
		Select Acct_DD = new Select(WebdriverWait.findElement("id", "paymentMethodId"));
		Acct_DD.selectByVisibleText("ICICI-2960");

		// Payment Method
		Select Paymethd_DD = new Select(WebdriverWait.findElement("id", "paymentMethod"));
		Paymethd_DD.selectByVisibleText("Cash");

		// Numbering Type
		Select NumType_DD = new Select(WebdriverWait.findElement("id", "numberingFormatId"));
		NumType_DD.selectByVisibleText("Receve pay");

		// Currency
		Select Cur_DD = new Select(WebdriverWait.findElement("id", "currencyUomId"));
		Cur_DD.selectByVisibleText("INR");

		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div/div[2]/form/table/tbody[1]/tr[10]/td/input").click();

		AR_Receipts_Header.PaymentIDCapture(sheetname);
		AR_Receipts_Applications.SelectInvoiceID(data);
		AR_Receipts_Overview.ConfirmPayment();
		Sales_SalesOrder_View.InvID_PaymntStatus_Val(data);

	}

}