Feature: SO Offline Payment Flow 

Background: Login to the Application 
	Given Launch the Application 
	Then Login with valid Credentials 
	
@Test31 
Scenario: Create Quotes - SO Offline Payment Flow

	Given Create New Sales Quote - SO Offline Payment Flow	
	
@Test32 
Scenario: Create SO - SO Offline Payment Flow

	Given Create New SO - SO Offline Payment Flow
	Then Add Shipping Details - SO Offline Payment Flow
	Then Add Order Items - SO Offline Payment Flow
	Then Review & Create SO - SO Offline Payment Flow
	Then Validate GrandTotal & Tax for SO - SO Offline Payment Flow
	And Approve SO - SO Offline Payment Flow

@Test33	
Scenario: Create Shipment - SO Offline Payment Flow

	Given  Create Shipment for all the facilities - SO Offline Payment Flow	

@Test34	
Scenario: Approve & Post all the Invoices - SO Offline Payment Flow

	Given Validate/Approve and Post all the Invoice ID - SO Offline Payment Flow	

@Test35	
Scenario: Make Payments for all the Invoices - SO Offline Payment Flow
	
	Given Make Payments for all the Invoice ID - SO Offline Payment Flow
	
@Test36 
Scenario: Create Sales Return - SO Offline Payment Flow 

	Given Create SO Return - SO Offline Payment Flow 
	
@Test37
Scenario: Validate all the Transactions under Finance Module - SO Offline Payment Flow

	Given Validate Accounting transactions with ShipmentID under Finance Module - SO Offline Payment Flow
	Then Validate Accounting transactions with InvoiceID under Finance Module - SO Offline Payment Flow
	Then Validate Accounting transactions with PaymentID under Finance Module - SO Offline Payment Flow
	
@Test38 
Scenario: Download and validate reports - SO Offline Payment Flow

	Given Validate Reports - SO Offline Payment Flow
	