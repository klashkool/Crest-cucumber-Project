Feature: PO with TDS Flow 


Background: Login to the Application 
	Given Launch the Application 
	Then Login with valid Credentials 
	
@Test71
Scenario: Create PO - PO TDS Flow 

	Given Create PO - PO TDS Flow 
	Then Add Shipping Details - PO TDS Flow
	Then Add Order Items - PO TDS Flow
	Then Review & Create PO - PO TDS Flow
	Then Validate GrandTotal - PO TDS Flow
	Then Approve PO - PO TDS Flow
	
@Test72 
Scenario: Receive PO - PO TDS Flow 

	Given  Receive Inventory for all the facilities - PO TDS Flow 
	
@Test73 
Scenario: Approve & Post all the Invoices - PO TDS Flow 

	Given Validate/Approve and Post all the Invoice ID - PO TDS Flow 	
	
