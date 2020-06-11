package com.Crest_Scenarios_StepDefinitions;

import java.util.HashMap;
import java.util.List;

import com.AccountReceivable_Modules.AR_Receipts;
import com.AccountReceivable_Modules.AR_SalesInvoice;
import com.Facilities_Modules.Facilities_Shipments;
import com.Financials_Modules.Financials_AcctTransaction;
import com.Financials_Modules.Financials_AcctTransaction_GLTransactionViewEntry;
import com.Party_Modules.Party_Parties;
import com.Party_Modules.Party_Parties_BasicConfigs_Profile;
import com.Sales_Modules.Sales_Quotes;
import com.Sales_Modules.Sales_SalesOrder;
import com.Sales_Modules.Sales_SalesOrder_View;
import com.Sales_Modules.Sales_SalesReturn;
import com.Utils.CrestTestDataReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SO_BillingAcct_Flow_Stepdef {

	List<HashMap<String, String>> SO_BillingAcct_data = CrestTestDataReader.getSO_BillingAcct_Data();

	@Given("^Create New Sales Quote - SO Billing Acct Flow$")
	public void create_New_Sales_Quote_SO_Billing_Acct_Flow() throws InterruptedException {
		Sales_Quotes.Create_SO_Quotes(SO_BillingAcct_data, "SO_BillingAcct");
	}

	// Capture Billing Account Balance

	@Given("^Capture Billing Acct Balance - SO Billing Acct Flow$")
	public void capture_Billing_Acct_Balance_SO_Billing_Acct_Flow() {
		Party_Parties.PartySearch("11651");// Workphilia
		Party_Parties_BasicConfigs_Profile.Capture_BillingAcct_Bal("SO_BillingAcct");

	}

	// Create SO - SO Billing Acct Flow

	@Given("^Create New SO - SO Billing Acct Flow$")
	public void create_New_SO_SO_Billing_Acct_Flow() {
		Sales_SalesOrder.SO_StartOrder(SO_BillingAcct_data, "SO Billing Acct Flow", "Domestic");
		Sales_SalesOrder.BillingAcct_Chkbox();
	}

	@Then("^Add Shipping Details - SO Billing Acct Flow$")
	public void add_Shipping_Details_SO_Billing_Acct_Flow() {
		Sales_SalesOrder.SO_ShippingDetails(SO_BillingAcct_data);
	}

	@Then("^Add Order Items - SO Billing Acct Flow$")
	public void add_Order_Items_SO_Billing_Acct_Flow() throws InterruptedException {
		Sales_SalesOrder.SO_OrderItems(SO_BillingAcct_data);
	}

	@Then("^Review & Create SO - SO Billing Acct Flow$")
	public void review_Create_SO_SO_Billing_Acct_Flow() {
		Sales_SalesOrder.SO_ReviewCreateSO("SO_BillingAcct");
	}

	@Then("^Validate GrandTotal & Tax for SO - SO Billing Acct Flow$")
	public void validate_GrandTotal_Tax_for_SO_SO_Billing_Acct_Flow() {
		Sales_SalesOrder_View.SO_GrdTotal_Val(SO_BillingAcct_data);
	}

	@Then("^Approve SO - SO Billing Acct Flow$")
	public void approve_SO_SO_Billing_Acct_Flow() {
		Sales_SalesOrder_View.Approve_SO();
	}

	// Scenario: Create Shipment - SO Billing Acct Flow

	@Given("^Create Shipment for all the facilities - SO Billing Acct Flow$")
	public void create_Shipment_for_all_the_facilities_SO_Billing_Acct_Flow() throws InterruptedException {
		Facilities_Shipments.SO_CreateShipment(SO_BillingAcct_data, "SO_BillingAcct");
	}

	// Scenario: Approve & Post all the Invoices - SO Billing Acct Flow

	@Given("^Validate/Approve and Post all the Invoice ID - SO Billing Acct Flow$")
	public void validate_Approve_and_Post_all_the_Invoice_ID_SO_Billing_Acct_Flow() {
		AR_SalesInvoice.SO_InvoicePosting(SO_BillingAcct_data);
	}

	// Scenario: Make Payments for all the Invoices - SO Billing Acct Flow

	@Given("^Make Payments for all the Invoice ID - SO Billing Acct Flow$")
	public void make_Payments_for_all_the_Invoice_ID_SO_Billing_Acct_Flow() throws InterruptedException {
		AR_Receipts.Receipts(SO_BillingAcct_data, "SO_BillingAcct");

	}

	// Validate Billing Account balance

	@Given("^Validate Billing Acct Balance - SO Billing Acct Flow$")
	public void validate_Billing_Acct_Balance_SO_Billing_Acct_Flow() {
		// Party_Parties.PartySearch("11440");// Dhinu Group Of Companies
		// Party_Parties_BasicConfigs_Profile.Val_BillingAcct_Bal(SO_BillingAcct_data,
		// "SO_BillingAcct");

	}

	// Scenario: Create Sales Return - SO Billing Acct Flow

	@Given("^Create SO Return - SO Billing Acct Flow$")
	public void create_SO_Return_SO_Billing_Acct_Flow() {
		Sales_SalesReturn.Sales_Return(SO_BillingAcct_data, "SO_BillingAcct");
	}

	// Scenario: Validate all the Transactions under Finance Module - SO Offline
	// Payment Flow

	@Given("^Validate Accounting transactions with ShipmentID under Finance Module - SO Billing Acct Flow$")
	public void validate_Accounting_transactions_with_ShipmentID_under_Finance_Module_SO_Billing_Acct_Flow() {
		Financials_AcctTransaction.Acct_Trans_Val();
		Financials_AcctTransaction_GLTransactionViewEntry.Acct_Trans_Val_ShipID(SO_BillingAcct_data, "141 - Raw Materials", "500000 - COST OF GOODS SOLD");

	}

	@Then("^Validate Accounting transactions with InvoiceID under Finance Module - SO Billing Acct Flow$")
	public void validate_Accounting_transactions_with_InvoiceID_under_Finance_Module_SO_Billing_Acct_Flow() {
		Financials_AcctTransaction.Acct_Trans_Val();
		Financials_AcctTransaction_GLTransactionViewEntry.Acct_Trans_Val_InvoiceID(SO_BillingAcct_data, "401000 - GENERAL SALES", "230025 - Input IGST", "",
						"115001 - Accounts Receivable (Debtors)INR", "C", "D");

	}

	@Then("^Validate Accounting transactions with PaymentID under Finance Module - SO Billing Acct Flow$")
	public void validate_Accounting_transactions_with_PaymentID_under_Finance_Module_SO_Billing_Acct_Flow() {
		Financials_AcctTransaction.Acct_Trans_Val();
		Financials_AcctTransaction_GLTransactionViewEntry.Acct_Trans_Val_PaymentID(SO_BillingAcct_data, "110201 - Kotak Bank #2711",
						"115001 - Accounts Receivable (Debtors)INR", "D", "C");

	}

	// Scenario: Download and validate reports - SO Billing Acct Flow

	@Given("^Validate Reports - SO Billing Acct Flow$")
	public void validate_Reports_SO_Billing_Acct_Flow() {

	}

}
