package com.Crest_Scenarios_StepDefinitions;

import java.util.HashMap;
import java.util.List;

import com.AccountReceivable_Modules.AR_Receipts;
import com.AccountReceivable_Modules.AR_SalesInvoice;
import com.Facilities_Modules.Facilities_Shipments;
import com.Financials_Modules.Financials_AcctTransaction;
import com.Financials_Modules.Financials_AcctTransaction_GLTransactionViewEntry;
import com.Sales_Modules.Sales_Quotes;
import com.Sales_Modules.Sales_SalesOrder;
import com.Sales_Modules.Sales_SalesOrder_View;
import com.Sales_Modules.Sales_SalesReturn;
import com.Utils.Base;
import com.Utils.CrestTestDataReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SO_OfflinePayment_Flow_Stepdef extends Base {

	List<HashMap<String, String>> SO_Offline_data = CrestTestDataReader.getSO_Offline_Data();

	@Given("^Create New Sales Quote - SO Offline Payment Flow$")
	public void create_New_Sales_Quote_SO_Offline_Payment_Flow() throws InterruptedException {
		Sales_Quotes.Create_SO_Quotes(SO_Offline_data, "SO_Offline");
	}

	// Create SO - SO Offline Payment Flow

	@Given("^Create New SO - SO Offline Payment Flow$")
	public void create_New_SO_SO_Offline_Payment_Flow() {
		Sales_SalesOrder.SO_StartOrder(SO_Offline_data, "SO Offline Payment Flow", "Domestic");
		Sales_SalesOrder.OfflinePayment_Chkbox();
	}

	@Then("^Add Shipping Details - SO Offline Payment Flow$")
	public void add_Shipping_Details_SO_Offline_Payment_Flow() {
		Sales_SalesOrder.SO_ShippingDetails(SO_Offline_data);
	}

	@Then("^Add Order Items - SO Offline Payment Flow$")
	public void add_Order_Items_SO_Offline_Payment_Flow() throws InterruptedException {
		Sales_SalesOrder.SO_OrderItems(SO_Offline_data);
	}

	@Then("^Review & Create SO - SO Offline Payment Flow$")
	public void review_Create_SO_SO_Offline_Payment_Flow() {
		Sales_SalesOrder.SO_ReviewCreateSO("SO_Offline");
	}

	@Then("^Validate GrandTotal & Tax for SO - SO Offline Payment Flow$")
	public void validate_GrandTotal_Tax_for_SO_SO_Offline_Payment_Flow() {
		// Sales_SalesOrder_View.SO_GrdTotal_Val(SO_Offline_data);
	}

	@Then("^Approve SO - SO Offline Payment Flow$")
	public void approve_SO_SO_Offline_Payment_Flow() {
		Sales_SalesOrder_View.Approve_SO();
	}

	// Scenario: Create Shipment - SO Offline Payment Flow

	@Given("^Create Shipment for all the facilities - SO Offline Payment Flow$")
	public void create_Shipment_for_all_the_facilities_SO_Offline_Payment_Flow() throws InterruptedException {
		Facilities_Shipments.SO_CreateShipment(SO_Offline_data, "SO_Offline");
	}

	// Scenario: Approve & Post all the Invoices - SO Offline Payment Flow

	@Given("^Validate/Approve and Post all the Invoice ID - SO Offline Payment Flow$")
	public void validate_Approve_and_Post_all_the_Invoice_ID_SO_Offline_Payment_Flow() {
		AR_SalesInvoice.SO_InvoicePosting(SO_Offline_data);
	}

	// Scenario: Make Payments for all the Invoices - SO Offline Payment Flow

	@Given("^Make Payments for all the Invoice ID - SO Offline Payment Flow$")
	public void make_Payments_for_all_the_Invoice_ID_SO_Offline_Payment_Flow() throws InterruptedException {
		AR_Receipts.Receipts(SO_Offline_data, "SO_Offline");

	}

	// Scenario: Create Sales Return - SO Offline Payment Flow

	@Given("^Create SO Return - SO Offline Payment Flow$")
	public void create_SO_Return_SO_Offline_Payment_Flow() {
		Sales_SalesReturn.Sales_Return(SO_Offline_data, "SO_Offline");
	}

	// Scenario: Validate all the Transactions under Finance Module - SO Offline
	// Payment Flow

	@Given("^Validate Accounting transactions with ShipmentID under Finance Module - SO Offline Payment Flow$")
	public void validate_Accounting_transactions_with_ShipmentID_under_Finance_Module_SO_Offline_Payment_Flow() {
		Financials_AcctTransaction.Acct_Trans_Val();
		Financials_AcctTransaction_GLTransactionViewEntry.Acct_Trans_Val_ShipID(SO_Offline_data, "141 - Raw Materials", "500000 - COST OF GOODS SOLD");

	}

	@Then("^Validate Accounting transactions with InvoiceID under Finance Module - SO Offline Payment Flow$")
	public void validate_Accounting_transactions_with_InvoiceID_under_Finance_Module_SO_Offline_Payment_Flow() {
		Financials_AcctTransaction.Acct_Trans_Val();
		Financials_AcctTransaction_GLTransactionViewEntry.Acct_Trans_Val_InvoiceID(SO_Offline_data, "401000 - GENERAL SALES", "230025 - Input IGST", "",
						"115001 - Accounts Receivable (Debtors)INR", "C", "D");

	}

	@Then("^Validate Accounting transactions with PaymentID under Finance Module - SO Offline Payment Flow$")
	public void validate_Accounting_transactions_with_PaymentID_under_Finance_Module_SO_Offline_Payment_Flow() {
		Financials_AcctTransaction.Acct_Trans_Val();
		Financials_AcctTransaction_GLTransactionViewEntry.Acct_Trans_Val_PaymentID(SO_Offline_data, "110201 - Kotak Bank #2711",
						"115001 - Accounts Receivable (Debtors)INR", "D", "C");

	}

	// Scenario: Download and validate reports - SO Offline Payment Flow

	@Given("^Validate Reports - SO Offline Payment Flow$")
	public void validate_Reports_SO_Offline_Payment_Flow() {

	}

}
