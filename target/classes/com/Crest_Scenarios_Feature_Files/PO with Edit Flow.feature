Feature: PO with Edit Flow 


Background: Login to the Application 
	Given Launch the Application 
	Then Login with valid Credentials 
	
@Test61
Scenario: Create PO - PO Edit Flow 

	Given Create PO - PO Edit Flow 
	Then Add Shipping Details - PO Edit Flow
	Then Add Order Items - PO Edit Flow
	Then Review & Create PO - PO Edit Flow
	Then Validate GrandTotal - PO Edit Flow
	Then Approve PO - PO Edit Flow

@Test62	
Scenario: Edit PO Discounts - PO Edit Flow

	Given Add Discounts to line Items - PO Edit Flow
	Then Validate Applied Discounts

@Test63	
Scenario: Edit PO Adjustments - PO Edit Flow

	Given Add Adjustments - PO Edit Flow
	Then Validate Applied Adjustments

@Test64	
Scenario: Edit PO Order Items - PO Edit Flow
	
	Given Add Line Items - PO Edit Flow
	Then Validate added Order Items - PO Edit Flow
	

	
	
	
	
	