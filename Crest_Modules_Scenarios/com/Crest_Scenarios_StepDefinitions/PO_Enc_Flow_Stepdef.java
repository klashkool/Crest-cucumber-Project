package com.Crest_Scenarios_StepDefinitions;

import com.Crest_ERP_Login.Crest_Login;
import com.Procurement_Modules.Procurement_PurchaseOrder;
import com.Utils.Base;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PO_Enc_Flow_Stepdef {

	// Scenario: Create PO with Encumbrance

	@Given("^Create New PO with Encumbrance & Enter Organization & Supplier$")
	public void create_New_PO_with_Encumbrance_Enter_Organization_Supplier() {
		Procurement_PurchaseOrder.PO_Enc_Start_Order();
	}

	@And("^Add Ship Groups for PO with Encumbrance$")
	public void add_Ship_Groups_for_PO_with_Encumbrance() {
		Procurement_PurchaseOrder.PO_Enc_Add_ShpGrps();
	}

	@And("^Add Products for PO with Encumbrance$")
	public void add_Products_for_PO_with_Encumbrance() throws InterruptedException {
		Procurement_PurchaseOrder.PO_Enc_Add_Prd();
	}

	@Then("^Validate GrandTotal & Tax for PO with Encumbrance$")
	public void validate_GrandTotal_Tax_for_PO_with_Encumbrance() {
		Procurement_PurchaseOrder.PO_Enc_GrdTotal_Val();
	}

	@And("^Approve PO for PO with Encumbrance$")
	public void approve_PO_for_PO_with_Encumbrance() {
		Procurement_PurchaseOrder.Po_Enc_Approve_Po();
	}

}
