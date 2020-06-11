Feature: PO with Inv & Adhoc Flow

Background: Login to the Application
Given Launch the Application
Then Login with valid Credentials


@Test10
Scenario: Create PO - PO Inv & Adhoc Flow

	Given Create PO Req - PO Inv & Adhoc Flow 
	Then Create PO RFQ - PO Inv & Adhoc Flow 
	Then Create PO Quote - PO Inv & Adhoc Flow 
	Then Review & Create PO - PO Inv & Adhoc Flow 
	Then Validate GrandTotal & Tax - PO Inv & Adhoc Flow 
	And Approve PO - PO Inv & Adhoc Flow 
	
@Test11
Scenario: Receive Inventory for Inv & Adhoc	
	
	Given Receive Inventory & Adhoc for all the facilities - PO Inv & Adhoc Flow 
	
@Test12
Scenario: Approve & Post all the Invoices - PO Inv & Adhoc Flow
	
	Given Validate/Approve and Post all the Invoice ID - PO Inv & Adhoc Flow
	
@Test13
Scenario: Make Payments for all the Invoices - PO Inv & Adhoc Flow

	Given Make payments for all the Invoices - PO Inv & Adhoc Flow 



	
	