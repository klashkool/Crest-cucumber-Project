package com.Crest_Scenarios_StepDefinitions;

import java.util.HashMap;
import java.util.List;

import com.AccountsPayable_Modules.AP_Payments;
import com.AccountsPayable_Modules.AP_PurchaseInvoices;
import com.Facilities_Modules.Facilities_Shipments;
import com.Procurement_Modules.Procurement_PurchaseOrder;
import com.Procurement_Modules.Procurement_PurchaseOrder_View;
import com.Procurement_Modules.Procurement_Quotes;
import com.Procurement_Modules.Procurement_RFQ;
import com.Procurement_Modules.Procurement_Requirements_Requirements;
import com.Utils.Base;
import com.Utils.CrestTestDataReader;
import com.Utils.WebdriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PO_Inv_Adhoc_Flow_Stepdef extends Base {

	List<HashMap<String, String>> PO_Adhoc_data = CrestTestDataReader.getPOInvAdhocData();

	// Scenario: Create PO - PO Inv & Adhoc Flow

	@Given("^Create PO Req - PO Inv & Adhoc Flow$")
	public void create_PO_Req_PO_Inv_Flow() throws InterruptedException {
		Procurement_Requirements_Requirements.PO_Req(PO_Adhoc_data, "PO_Adhoc");
	}

	@Then("^Create PO RFQ - PO Inv & Adhoc Flow$")
	public void create_PO_RFQ_PO_Inv_Flow() throws InterruptedException {
		Procurement_RFQ.PO_RFQ(PO_Adhoc_data, "PO_Adhoc");
	}

	@Then("^Create PO Quote - PO Inv & Adhoc Flow$")
	public void create_PO_Quote_PO_Inv_Flow() {
		Procurement_Quotes.PO_Quotes(PO_Adhoc_data);
		WebdriverWait.findElement("link", "Continue").click();
		WebdriverWait.findElement("link", "Continue").click();
		WebdriverWait.findElement("link", "Continue").click();

	}

	@Then("^Review & Create PO - PO Inv & Adhoc Flow$")
	public void review_Create_PO_PO_Inv_Adhoc_Flow() {
		Procurement_PurchaseOrder.PO_ReviewCreatePO("PO_Adhoc");
	}

	@Then("^Validate GrandTotal & Tax - PO Inv & Adhoc Flow$")
	public void validate_GrandTotal_Tax_PO_Inv_Adhoc_Flow() {
		// Procurement_PurchaseOrder_View.PO_GrdTotal_Val(PO_Adhoc_data);
	}

	@Then("^Approve PO - PO Inv & Adhoc Flow$")
	public void approve_PO_PO_Inv_Adhoc_Flow() {
		Procurement_PurchaseOrder_View.PO_Approve();
	}

	// Scenario: Receive Inventory for Inv & Adhoc

	@Given("^Receive Inventory & Adhoc for all the facilities - PO Inv & Adhoc Flow$")
	public void receive_Inventory_for_all_the_facilities_PO_Inv_Adhoc_Flow() throws InterruptedException {
		Facilities_Shipments.PO_Adhoc_ReceiveInv(PO_Adhoc_data, "PO_Adhoc");
		Procurement_PurchaseOrder_View.CaptureInvID("PO_Adhoc");

	}

	@Given("^Validate/Approve and Post all the Invoice ID - PO Inv & Adhoc Flow$")
	public void validate_Approve_and_Post_all_the_Invoice_ID_PO_Inv_Adhoc_Flow() throws InterruptedException {
		AP_PurchaseInvoices.InvoicePosting(PO_Adhoc_data);
	}

	@Given("^Make payments for all the Invoices - PO Inv & Adhoc Flow$")
	public void make_payments_for_all_the_Invoices_PO_Inv_Adhoc_Flow() throws InterruptedException {
		AP_Payments.Payments(PO_Adhoc_data, "PO_Adhoc");
	}

}