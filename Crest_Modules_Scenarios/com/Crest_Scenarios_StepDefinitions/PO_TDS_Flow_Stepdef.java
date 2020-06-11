package com.Crest_Scenarios_StepDefinitions;

import java.util.HashMap;
import java.util.List;

import com.AccountsPayable_Modules.AP_PurchaseInvoices;
import com.Facilities_Modules.Facilities_Shipments;
import com.Procurement_Modules.Procurement_PurchaseOrder;
import com.Procurement_Modules.Procurement_PurchaseOrder_View;
import com.Utils.Base;
import com.Utils.CrestTestDataReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PO_TDS_Flow_Stepdef extends Base {

	List<HashMap<String, String>> PO_TDS_data = CrestTestDataReader.get_PO_TDS_Data();

	// Scenario: Create PO - PO TDS Flow

	@Given("^Create PO - PO TDS Flow$")
	public void create_PO_PO_TDS_Flow() {
		Procurement_PurchaseOrder.PO_Start_Order(PO_TDS_data, "PO TDS Flow", "Normal");
	}

	@Then("^Add Shipping Details - PO TDS Flow$")
	public void add_Shipping_Details_PO_TDS_Flow() {
		Procurement_PurchaseOrder.PO_Shipping_Details(PO_TDS_data);
	}

	@Then("^Add Order Items - PO TDS Flow$")
	public void add_Order_Items_PO_TDS_Flow() throws InterruptedException {
		Procurement_PurchaseOrder.PO_OrderItems(PO_TDS_data);
	}

	@Then("^Review & Create PO - PO TDS Flow$")
	public void review_Create_PO_PO_TDS_Flow() {
		Procurement_PurchaseOrder.PO_ReviewCreatePO_TDS("PO_TDS");

	}

	@Then("^Validate GrandTotal - PO TDS Flow$")
	public void validate_GrandTotal_PO_TDS_Flow() {
		// Procurement_PurchaseOrder_View.PO_GrdTotal_Val(PO_TDS_data);
	}

	@Then("^Approve PO - PO TDS Flow$")
	public void approve_PO_PO_TDS_Flow() {
		Procurement_PurchaseOrder_View.PO_Approve();
	}

	// Scenario: Receive PO - PO TDS Flow

	@Given("^Receive Inventory for all the facilities - PO TDS Flow$")
	public void receive_Inventory_for_all_the_facilities_PO_TDS_Flow() throws InterruptedException {
		Facilities_Shipments.PO_ReceiveInv(PO_TDS_data, "PO_TDS");
		Procurement_PurchaseOrder_View.CaptureInvID("PO_TDS");

	}

	// Scenario: Approve & Post all the Invoices - PO TDS Flow

	@Given("^Validate/Approve and Post all the Invoice ID - PO TDS Flow$")
	public void validate_Approve_and_Post_all_the_Invoice_ID_PO_TDS_Flow() throws InterruptedException {
		AP_PurchaseInvoices.InvoicePosting(PO_TDS_data);

	}

}
