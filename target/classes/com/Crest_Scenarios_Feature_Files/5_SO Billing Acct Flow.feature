Feature: SO Billing Account Flow 

Background: Login to the Application 
	Given Launch the Application 
	Then Login with valid Credentials 
	
@Test41 
Scenario: Create Quotes - SO Billing Acct Flow

	Given Create New Sales Quote - SO Billing Acct Flow	
	
@Test42
Scenario:  Capture Billing Acct Balance - SO Billing Acct Flow

	Given Capture Billing Acct Balance - SO Billing Acct Flow
	
@Test43 
Scenario: Create SO - SO Billing Acct Flow

	Given Create New SO - SO Billing Acct Flow
	Then Add Shipping Details - SO Billing Acct Flow
	Then Add Order Items - SO Billing Acct Flow
	Then Review & Create SO - SO Billing Acct Flow
	Then Validate GrandTotal & Tax for SO - SO Billing Acct Flow
	And Approve SO - SO Billing Acct Flow

@Test44	
Scenario: Create Shipment - SO Billing Acct Flow

	Given  Create Shipment for all the facilities - SO Billing Acct Flow	

@Test45
Scenario: Approve & Post all the Invoices - SO Billing Acct Flow

	Given Validate/Approve and Post all the Invoice ID - SO Billing Acct Flow	

@Test46	
Scenario: Make Payments for all the Invoices - SO Billing Acct Flow
	
	Given Make Payments for all the Invoice ID - SO Billing Acct Flow
	
@Test47
Scenario: Validate Billing Acct Balance - SO Billing Acct Flow

	Given Validate Billing Acct Balance - SO Billing Acct Flow
	
@Test48 
Scenario: Create Sales Return - SO Billing Acct Flow 

	Given Create SO Return - SO Billing Acct Flow 
	
@Test49
Scenario: Validate all the Transactions under Finance Module - SO Billing Acct Flow

	Given Validate Accounting transactions with ShipmentID under Finance Module - SO Billing Acct Flow
	Then Validate Accounting transactions with InvoiceID under Finance Module - SO Billing Acct Flow
	Then Validate Accounting transactions with PaymentID under Finance Module - SO Billing Acct Flow
	
@Test50 
Scenario: Download and validate reports - SO Billing Acct Flow

	Given Validate Reports - SO Billing Acct Flow
	