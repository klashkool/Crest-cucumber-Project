package com.Crest_Scenarios_StepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.AccountsPayable_Modules.AP_Payments;
import com.AccountsPayable_Modules.AP_PurchaseInvoices;
import com.Crest_ERP_Login.Crest_Login;
import com.Facilities_Modules.Facilities_Shipments;
import com.Financials_Modules.Financials_AcctTransaction;
import com.Financials_Modules.Financials_AcctTransaction_GLTransactionViewEntry;
import com.Procurement_Modules.Procurement_PurchaseOrder;
import com.Procurement_Modules.Procurement_PurchaseOrder_View;
import com.Procurement_Modules.Procurement_PurchaseReturn;
import com.Procurement_Modules.Procurement_Quotes;
import com.Procurement_Modules.Procurement_RFQ;
import com.Procurement_Modules.Procurement_Requirements_Requirements;
import com.Utils.Base;
import com.Utils.CrestTestDataReader;
import com.Utils.WebdriverWait;
import com.Utils.testexcelreport_val;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PO_Inventory_Flow_Stepdef extends Base {

	List<HashMap<String, String>> PO_Inv_data = CrestTestDataReader.getPOInvData();
	List<HashMap<String, String>> ml_data = CrestTestDataReader.get_ML_Data();

	// Crest Login
	@Given("^Launch the Application$")
	public void launch_the_Application() {
		PO_Inv_data = CrestTestDataReader.getPOInvData();
		// ml_data = CrestTestDataReader.get_ML_Data();
		Base.initialization();
	}

	@Then("^Login with valid Credentials$")
	public void login_with_valid_Credentials() {
		Crest_Login.Login();
		// Crest_Login.ML_login();
		// Misterlight_InvPrice_Change.ML_PriceUpdate(ml_data);
	}

	// Create PO from Req - PO Inv Flow

	@Given("^Create PO Req - PO Inv Flow$")
	public void create_PO_Req_PO_Inv_Flow() throws InterruptedException {
		// Crest_Login.PurchaseExc_login();
		Procurement_Requirements_Requirements.PO_Req_Inv(PO_Inv_data, "PO_Inv");
	}

	@Then("^Create PO RFQ - PO Inv Flow$")
	public void create_PO_RFQ_PO_Inv_Flow() throws InterruptedException {
		Procurement_RFQ.PO_RFQ(PO_Inv_data, "PO_Inv");
	}

	@Then("^Create PO Quote - PO Inv Flow$")
	public void create_PO_Quote_PO_Inv_Flow() {
		Procurement_Quotes.PO_Quotes(PO_Inv_data);
		WebdriverWait.findElement("link", "Continue").click();
		WebdriverWait.findElement("link", "Continue").click();
		WebdriverWait.findElement("link", "Continue").click();

	}

	@Then("^Review & Create PO - PO Inv Flow$")
	public void review_Create_PO_PO_Inv_Flow() {
		Procurement_PurchaseOrder.PO_ReviewCreatePO("PO_Inv");
	}

	@Then("^Validate GrandTotal & Tax - PO Inv Flow$")
	public void validate_GrandTotal_Tax_PO_Inv_Flow() {
		// Procurement_PurchaseOrder_View.PO_GrdTotal_Val(PO_Inv_data);
	}

	@Then("^Approve PO - PO Inv Flow$")
	public void approve_PO_PO_Inv_Flow() {
		Procurement_PurchaseOrder_View.PO_Approve();
		// Procurement_PurchaseOrder_View.PO_WFC_Approvals(PO_Inv_data);

	}

	// Scenario: Receive PO - PO Inv Flow

	@Given("^Receive Inventory for all the facilities - PO Inv Flow$")
	public void receive_Inventory_for_all_the_facilities_PO_Inv_Flow() throws InterruptedException {
		Facilities_Shipments.PO_ReceiveInv(PO_Inv_data, "PO_Inv");
		Procurement_PurchaseOrder_View.CaptureInvID("PO_Inv");
	}

	// Scenario: Approve & Post all the Invoices - PO Inv Flow

	@Given("^Validate/Approve and Post all the Invoice ID - PO Inv Flow$")
	public void validate_Approve_and_Post_all_the_Invoice_ID_PO_Inv_Flow() throws InterruptedException {
		AP_PurchaseInvoices.InvoicePosting(PO_Inv_data);
	}

	// Scenario: Make Payments for all the Invoices - PO Inv Flow

	@Given("^Make payments for all the Invoices - PO Inv Flow$")
	public void make_payments_for_all_the_Invoices_PO_Inv_Flow() throws InterruptedException {
		AP_Payments.Payments(PO_Inv_data, "PO_Inv");

	}

	// Scenario: Create Purchase Return - PO Inv Flow

	@Given("^Create PO Return - PO Inv Flow$")
	public void create_PO_Return_PO_Inv_Flow() {
		Procurement_PurchaseReturn.PO_Return(PO_Inv_data, "PO_Inv");
	}

	// Scenario: Validate all the Inventories under Finance Module

	@Given("^Validate Accounting transactions with ShipmentID under Finance Module - PO Inv Flow$")
	public void validate_Accounting_transactions_with_ShipmentID_under_Finance_Module_PO_Inv_Flow() {
		Financials_AcctTransaction.Acct_Trans_Val();
		Financials_AcctTransaction_GLTransactionViewEntry.Acct_Trans_Val_ShipID(PO_Inv_data, "214000 - UNINVOICED ITEM RECEIPTS", "141 - Raw Materials");

	}

	@Then("^Validate Accounting transactions with InvoiceID under Finance Module - PO Inv Flow$")
	public void validate_Accounting_transactions_with_InvoiceID_under_Finance_Module_PO_Inv_Flow() {
		// Financials_AcctTransaction.Acct_Trans_Val();
		// Financials_AcctTransaction_GLTransactionViewEntry.Acct_Trans_Val_InvoiceID(PO_Inv_data,
		// "211 - Purchase control - AP", "230026 - Input CGST Tax RCM",
		// "", "210000 - Accounts Payable (Creditors)", "D", "C");

	}

	@Then("^Validate Accounting transactions with PaymentID under Finance Module - PO Inv Flow$")
	public void validate_Accounting_transactions_with_PaymentID_under_Finance_Module_PO_Inv_Flow() {
		Financials_AcctTransaction.Acct_Trans_Val();
		Financials_AcctTransaction_GLTransactionViewEntry.Acct_Trans_Val_PaymentID(PO_Inv_data, "110201 - Kotak Bank #2711",
						"210000 - Accounts Payable (Creditors)", "C", "D");

	}

	// Excel Reports

	@Given("^Validate Reports$")
	public void validate_Reports() throws InterruptedException {
		testexcelreport_val.testexcel(PO_Inv_data);

	}

	@After

	public void TearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotBytes, "image/png");
		}

		if (driver != null) {
			driver.quit();
		}
	}
}