package com.Crest_Scenarios_StepDefinitions;

import java.util.HashMap;
import java.util.List;

import com.Crest_ERP_Login.Crest_Login;
import com.Procurement_Modules.Procurement_PurchaseOrder;
import com.Procurement_Modules.Procurement_PurchaseOrder_View;
import com.Utils.Base;
import com.Utils.CrestTestDataReader;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PO_Edit_Flow_Stepdef extends Base {

	List<HashMap<String, String>> PO_Edit_data = CrestTestDataReader.get_PO_Edit_Data();

	// Scenario: Create PO - PO Edit Flow

	@Given("^Create PO - PO Edit Flow$")
	public void create_PO_PO_Edit_Flow() {
		Crest_Login.PurchaseExc_login();
		Procurement_PurchaseOrder.PO_Start_Order(PO_Edit_data, "PO Edit Flow", "Normal");

	}

	@Then("^Add Shipping Details - PO Edit Flow$")
	public void add_Shipping_Details_PO_Edit_Flow() {
		Procurement_PurchaseOrder.PO_Shipping_Details(PO_Edit_data);
	}

	@Then("^Add Order Items - PO Edit Flow$")
	public void add_Order_Items_PO_Edit_Flow() throws InterruptedException {
		Procurement_PurchaseOrder.PO_OrderItems(PO_Edit_data);

	}

	@Then("^Review & Create PO - PO Edit Flow$")
	public void review_Create_PO_PO_Edit_Flow() {
		Procurement_PurchaseOrder.PO_ReviewCreatePO("PO_Edit");

	}

	@Then("^Validate GrandTotal - PO Edit Flow$")
	public void validate_GrandTotal_PO_Edit_Flow() {
		// Procurement_PurchaseOrder_View.PO_GrdTotal_Val(PO_Edit_data);

	}

	@Then("^Approve PO - PO Edit Flow$")
	public void approve_PO_PO_Edit_Flow() {
		Procurement_PurchaseOrder_View.PO_Approve();
		// Procurement_PurchaseOrder_View.PO_WFC_Approvals(PO_Edit_data);
	}

	// Scenario: Edit PO Discounts - PO Edit Flow

	@Given("^Add Discounts to line Items - PO Edit Flow$")
	public void add_Discounts_to_line_Items_PO_Edit_Flow() {
		Procurement_PurchaseOrder.Edit_lineItem_Discounts(PO_Edit_data);

	}

	@Then("^Validate Applied Discounts$")
	public void validate_Applied_Discounts() {
		Procurement_PurchaseOrder_View.PO_GrdTotal_Val1(PO_Edit_data, 11, "Consolidated Grand Total");
	}

	// Scenario: Edit PO Adjustments - PO Edit Flow

	@Given("^Add Adjustments - PO Edit Flow$")
	public void add_Adjustments_PO_Edit_Flow() {
		Procurement_PurchaseOrder.Edit_Adjustments(PO_Edit_data);

	}

	@Then("^Validate Applied Adjustments$")
	public void validate_Applied_Adjustments() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	// Scenario: Edit PO Order Items - PO Edit Flow

	@Given("^Add Line Items - PO Edit Flow$")
	public void add_Line_Items_PO_Edit_Flow() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Validate added Order Items - PO Edit Flow$")
	public void validate_added_Order_Items_PO_Edit_Flow() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
