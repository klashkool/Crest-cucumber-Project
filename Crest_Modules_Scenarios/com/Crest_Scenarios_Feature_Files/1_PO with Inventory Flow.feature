Feature: PO with Inventory Flow 


Background: Login to the Application 
	Given Launch the Application 
	Then Login with valid Credentials 
	
@Test2 
Scenario: Create PO from Req - PO Inv Flow 

	Given Create PO Req - PO Inv Flow 
	Then Create PO RFQ - PO Inv Flow 
	Then Create PO Quote - PO Inv Flow 
	Then Review & Create PO - PO Inv Flow 
	Then Validate GrandTotal & Tax - PO Inv Flow 
	And Approve PO - PO Inv Flow 
	
@Test3 
Scenario: Receive PO - PO Inv Flow 

	Given  Receive Inventory for all the facilities - PO Inv Flow 
	
@Test4 
Scenario: Approve & Post all the Invoices - PO Inv Flow 

	Given Validate/Approve and Post all the Invoice ID - PO Inv Flow 	
	
@Test5 
Scenario: Make Payments for all the Invoices - PO Inv Flow 

	Given Make payments for all the Invoices - PO Inv Flow 
	
@Test6 
Scenario: Create Purchase Return - PO Inv Flow 

	Given Create PO Return - PO Inv Flow 
	
@Test7
Scenario: Validate all the Inventories under Finance Module - PO Inv Flow

	Given Validate Accounting transactions with ShipmentID under Finance Module - PO Inv Flow
	Then Validate Accounting transactions with InvoiceID under Finance Module - PO Inv Flow
	Then Validate Accounting transactions with PaymentID under Finance Module - PO Inv Flow 
	
@Test8 
Scenario: Download and validate reports - PO Inv Flow 

	Given Validate Reports - PO Inv Flow
	
	
	